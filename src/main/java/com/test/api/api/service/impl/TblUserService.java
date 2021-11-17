package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblUser;
import com.test.api.api.bean.TblUserLikes;
import com.test.api.api.bo.UserBo;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ITblUserLikesService;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.*;
import com.test.api.api.vo.UserVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className TblUserService
 * @description 用户管理业务逻辑接口实现类
 * @auther wangsheng
 * @creatTime 2020/11/6 12:31 上午
 * @company demo
 * @department demo
 */
@Service
public class TblUserService extends CommonService implements ITblUserService {

    protected static Logger logger = LoggerFactory.getLogger(TblUserService.class);

    @Value("${login.time}")
    private String time;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private TblUserDao userDao;

    @Autowired
    private ITblUserLikesService userLikesService;

    @Override
    public TblUser login(String id, String pass) {
        TblUser userInfo = userDao.login(id, pass);
        String userKey = id + StringUtil.uuid();
        String redisUserDataOperKey = id + StringUtil.uuid();
        HttpSession session = SessionUtils.getHttpSession();
        logger.info("[登录] sessionID= " + session.getId());
        session.setAttribute(CommConstant.REDIS_USER_KEY, userKey);
        session.setAttribute(CommConstant.REDIS_USER_DATA_OPER_KEY, redisUserDataOperKey);
        // 保存用户登录信息
        redisTemplate.opsForValue().set(userKey, JsonUtils.objectToJson(userInfo), Long.valueOf(time), TimeUnit.SECONDS);
        // 更新用户数据操作权限
        this.updateUserDataOper(id);
        return userInfo;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(userDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    @Transactional
    public String insert(UserBo user) {
        // 用户主键
        String userId = getUserId();
        user.setId(userId);
        // 保存用户信息
        String oldPath = user.getHeadPortraitUrl();
        if(!StringUtils.isEmpty(oldPath)){
            String fileName = userId + CommConstant.UNDERLINE + oldPath.substring(oldPath.lastIndexOf(File.separator) + 1, oldPath.length());
            String newPath = FileUtil.fixFileName(oldPath,fileName);
            user.setHeadPortraitUrl(newPath);
        }
        // 设置默认密码
        user.setPass(CommConstant.DEFAULT_PASSS);
        TblUser loginUser = getLoginUser();
        String loginUserId = loginUser.getId();
        user.setCreateUser(loginUserId);
        userDao.insert(user);
        logger.info("用户数据基础保存完成");
        String[] likes = user.getLikes();
        // 循环保存用户喜好
        this.addUserLikes(likes, userId, loginUserId);
        return userId;
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public UserVO queryUserById(String id) {
        TblUser user = userDao.selectByPKDelTag(id, DelTagEnum.DEL_TAG_2.getCode());
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        List<String> likes = userLikesService.queryUserLikeIds(id);
        likes = likes == null ? new ArrayList<>() : likes;
        vo.setLikes(likes);
        return vo;
    }

    @Override
    @Transactional
    public int update(UserBo user) throws AppException {
        String userId = user.getId();
        // 先查出原来的用户信息
        UserVO oldUser = this.queryUserById(userId);
        if(oldUser == null){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.USER_INFO_IS_NULL);
        }
        // 处理爱好数据，处理逻辑是：把原来的献删除，新的爱好直接新增
        // 删除原来的爱好
        if(oldUser.getLikes().size()>0){
            userLikesService.deleteByUserId(userId);
        }
        // 添加新的爱好
        String[] likes = user.getLikes();
        TblUser loginUser = getLoginUser();
        String loginUserId = loginUser.getId();
        this.addUserLikes(likes, userId, loginUserId);
        user.setUpdateUser(loginUserId);
        return userDao.update(user);
    }

    @Override
    public Cursor<TblUser> test() {
        return userDao.test();
    }

    @Override
    public int resetPass(UserBo user) {
        return userDao.resetPass(user);
    }

    @Override
    public void signOut() {
        HttpSession session = SessionUtils.getHttpSession();
        String userKey = (String)session.getAttribute(CommConstant.REDIS_USER_KEY);
        String redisUserDataOperKey = (String)session.getAttribute(CommConstant.REDIS_USER_DATA_OPER_KEY);
        boolean b = redisTemplate.delete(userKey);
        logger.info("[退出登录] Redis 删除用户登录新消息删除结果: " + b);
        // 清除保存的用户数据操作权限
        boolean b2 = redisTemplate.delete(redisUserDataOperKey);
        logger.info("[退出登录] Redis 删除保存的用户数据操作权限结果: " + b2);
    }

    @Override
    public List<TblUser> queryAllUser() {
        JSONObject param = new JSONObject();
        param.put(CommConstant.DEL_TAG, DelTagEnum.DEL_TAG_2.getCode());
        List<TblUser> userList = userDao.queryList(param);
        return userList;
    }

    @Override
    public TblUser selectByPKDelTag(String id, String delTag) {
        return userDao.selectByPKDelTag(id, delTag);
    }

    @Override
    public void updateUserDataOper(String userNo) {
        String redisUserDataOperKey = userNo + StringUtil.uuid();
        HttpSession session = SessionUtils.getHttpSession();
        session.setAttribute(CommConstant.REDIS_USER_DATA_OPER_KEY, redisUserDataOperKey);
        // 查询用户数据操作权限数据
        List<String> dataOperList = userDao.queryUserOperData(userNo, DelTagEnum.DEL_TAG_2.getCode());
        // 保存用户数据操作权限，退出登录时清除
        redisTemplate.opsForValue().set(redisUserDataOperKey, JsonUtils.objectToJson(dataOperList));
    }

    /**
     * 循环保存用户爱好
     * @param likes 爱好
     * @param userId 用户编号
     */
    private void addUserLikes(String[] likes, String userId, String loginUserId){
        // 循环保存用户喜好
        for (String item : likes){
            TblUserLikes userLikes = new TblUserLikes();
            String likesId = StringUtil.uuid();
            userLikes.setTitleCode(item);
            userLikes.setId(likesId);
            userLikes.setUserId(userId);
            userLikes.setCreateUser(loginUserId);
            userLikesService.insertSelective(userLikes);
            logger.info("用户喜好数据保存完成");
        }
    }
}
