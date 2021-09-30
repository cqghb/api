package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.utils.JsonUtils;
import com.test.api.api.utils.SessionUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className CommonService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/5/15 12:42 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class CommonService implements ICommonService {

    protected static Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private TblUserDao userDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public String getUserId() {
        String userId = StringUtil.getRandom();
        boolean r = true;
        // 记录用了几次才生成出了可用的字符串
        int num = 0;
        // 直到生成一个没有被使用的userNo就不再循环,
        // TODO 当字符用完之后将陷入死循环
        while (r){
            TblUser user = userDao.selectByPrimaryKey(userId);
            if(StringUtils.isEmpty(user)){
                r = false;
            } else {
                userId = StringUtil.getRandom();
            }
            num ++;
        }
        logger.info("共循环了 " + num + " 次后生成了可用的userNo");
        logger.info("生成的userNo: " + userId);
        return userId;
    }

    @Override
    public TblUser getLoginUser() {
        HttpSession session = SessionUtils.getHttpSession();
        String userKey = (String)session.getAttribute(CommConstant.REDIS_USER_KEY);
        String loginUserStr = (String)redisTemplate.opsForValue().get(userKey);
        TblUser loginUser = JsonUtils.jsonToPojo(loginUserStr, TblUser.class);
        return loginUser;
    }

    @Override
    public PageInfo<?> getPageInfo(Object dao, String methodName, PageRequest pageRequest) throws AppException {
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageRequest.getParams());
        List<?> dataList = new ArrayList<>();
        try {
            Class clazz = dao.getClass();
            Method method = clazz.getMethod(methodName, new Class[]{JSONObject.class});
            method.setAccessible(true);
            // 反射调用可变参数方法
            dataList = (List<?>) method.invoke(dao, new Object[]{jsonObject});
        } catch (Exception e) {
            logger.error("数据查询异常: " + e.getMessage(), e);
            throw new AppException(MsgCodeConstant.ERROR_CODE, "数据查询异常: " + e.getMessage());
        }
        return new PageInfo<>(dataList);
    }
}
