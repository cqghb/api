package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblUser;
import com.test.api.api.bean.TblUserLikes;
import com.test.api.api.bo.UserBo;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblUserLikesService;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.FileUtil;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

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
public class TblUserService implements ITblUserService {

    protected static Logger logger = LoggerFactory.getLogger(TblUserService.class);
    @Autowired
    private TblUserDao userDao;

    @Autowired
    private ICommonService commonService;

    @Autowired
    private ITblUserLikesService userLikesService;

    @Override
    public List<TblUser> queryList(TblUser user) {
        return userDao.queryList(user);
    }

    @Override
    public TblUser login(String id, String pass) {
        return userDao.login(id, pass);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public String insert(UserBo user) {
        // 用户主键
        String userId = commonService.getUserId();
        user.setId(userId);
        // 保存用户信息
        String oldPath = user.getHeadPortraitUrl();
        if(!StringUtils.isEmpty(oldPath)){
            String fileName = userId + CommConstant.UNDERLINE + oldPath.substring(oldPath.lastIndexOf(File.separator) + 1, oldPath.length());
            String newPath = FileUtil.fixFileName(oldPath,fileName);
            user.setHeadPortraitUrl(newPath);
        }

        userDao.insert(user);

        logger.info("用户数据基础保存完成");

        String[] likes = user.getLikes();
        // 循环保存用户喜好
        for (String item : likes){
            TblUserLikes userLikes = new TblUserLikes();
            String likesId = StringUtil.uuid();
            userLikes.setTitleCode(item);
            userLikes.setId(likesId);
            userLikes.setUserId(userId);
            // TODO 暂时先用这个客户号来填入，后期登录功能完善之后，再来改这里
            userLikes.setCreateUser(userId);
            userLikesService.insertSelective(userLikes);
            logger.info("用户喜好数据保存完成");
        }
        return userId;
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public TblUser queryUserById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public int update(TblUser user) {
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

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<TblUser> getPageInfo(PageRequest pageRequest) {
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject)JSON.toJSON(pageRequest.getParams());
        TblUser params = jsonObject.toJavaObject(TblUser.class);
        List<TblUser> userList = userDao.queryList(params);
        return new PageInfo<>(userList);
    }
}
