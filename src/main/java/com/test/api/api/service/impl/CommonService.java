package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
        while (r) {
            TblUser user = userDao.selectByPrimaryKey(userId);
            if (StringUtils.isEmpty(user)) {
                r = false;
            } else {
                userId = StringUtil.getRandom();
            }
            num++;
        }
        logger.info("共循环了 " + num + " 次后生成了可用的userNo");
        logger.info("生成的userNo: " + userId);
        return userId;
    }

    @Override
    public TblUser getLoginUser() {
        HttpSession session = SessionUtils.getHttpSession();
        String userKey = (String) session.getAttribute(CommConstant.REDIS_USER_KEY);
        String loginUserStr = (String) redisTemplate.opsForValue().get(userKey);
        TblUser loginUser = JsonUtils.jsonToPojo(loginUserStr, TblUser.class);
        return loginUser;
    }

    @Override
    public PageInfo<?> getPageInfo(Object dao, String methodName, PageRequest pageRequest) throws AppException {
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageRequest.getParams());
        jsonObject.put(CommConstant.DEL_TAG, DelTagEnum.DEL_TAG_2.getCode());
        List<?> dataList = new ArrayList<>();
        try {
            Class clazz = dao.getClass();
            Method method = clazz.getMethod(methodName, new Class[]{JSONObject.class});
//            持久层方法需要反射调用的都是public
//            method.setAccessible(true);
            // 反射调用可变参数方法
            dataList = (List<?>) method.invoke(dao, new Object[]{jsonObject});
        } catch (Exception e) {
            logger.error("数据查询异常: " + e.getMessage(), e);
            throw new AppException(MsgCodeConstant.ERROR_CODE, "数据查询异常: " + e.getMessage());
        }
        return new PageInfo<>(dataList);
    }

    @Override
    public <T> T getInfo(Object dao, String methodName, String id) throws AppException {
        T data = null;
        try {
            Class clazz = dao.getClass();
            Method method = clazz.getMethod(methodName, new Class[]{String.class});
            data = (T) method.invoke(dao, new Object[]{id});
            if (StringUtil.objIsEmpty(data)) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, "数据不存在");
            }
        } catch (Exception e) {
            logger.error("数据查询异常: " + e.getMessage(), e);
            throw new AppException(MsgCodeConstant.ERROR_CODE, "数据查询异常: " + e.getMessage());
        }
        return data;
    }

    @Override
    public void setObjectUpdateInfo(Object obj, String loginUserId) throws AppException {
        try {
            List<Field> fieldsList = this.getFieldsList(obj);
            for (Field field : fieldsList) {  // 打印当前类以及其父类的多有属性对象
                // 后面有新的字段可以都像这样加
                if (field.getName().equals(CommConstant.UPDATE_USER)) {
                    field.setAccessible(true);
                    if (StringUtil.objIsEmpty(loginUserId)) {
                        TblUser loginUser = getLoginUser();
                        loginUserId = loginUser.getId();
                    }
                    field.set(obj, loginUserId);
                    continue;
                }
            }
        } catch (IllegalAccessException e) {
            logger.info("没有权限访问对象的 " + CommConstant.UPDATE_USER + " 属性");
        }
    }

    @Override
    public void setObjectInsertInfo(Object obj, String loginUserId) throws AppException {
        try {
            List<Field> fieldsList = this.getFieldsList(obj);
            for (Field field : fieldsList) {  // 打印当前类以及其父类的多有属性对象
                // 后面有新的字段可以都像这样加
                if (field.getName().equals(CommConstant.CREATE_USER)) {
                    field.setAccessible(true);
                    if (StringUtil.objIsEmpty(loginUserId)) {
                        TblUser loginUser = getLoginUser();
                        loginUserId = loginUser.getId();
                    }
                    field.set(obj, loginUserId);
                    continue;
                }
                if (field.getName().equals(CommConstant.DEL_TAG)) {
                    field.setAccessible(true);
                    field.set(obj, DelTagEnum.DEL_TAG_1.getCode());
                    continue;
                }
            }
        } catch (IllegalAccessException e) {
            logger.info("没有权限访问对象的 " + CommConstant.CREATE_USER + " 属性");
        }
    }

    /**
     * 通过反射拿到对象包括直接父类的属性
     * @param obj
     * @return
     */
    private List<Field> getFieldsList(Object obj){
        Class clazz = obj.getClass();
        List<Field> fieldsList = new ArrayList<Field>();  // 保存属性对象数组到列表
        while (clazz != null) {  // 遍历所有父类字节码对象
            Field[] declaredFields = clazz.getDeclaredFields();  // 获取字节码对象的属性对象数组
            fieldsList.addAll(Arrays.asList(declaredFields));

            clazz = clazz.getSuperclass();  // 获得父类的字节码对象
        }
        return fieldsList;
    }
}
