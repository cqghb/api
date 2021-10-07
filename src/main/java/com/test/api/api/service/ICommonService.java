package com.test.api.api.service;

import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.page.PageRequest;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ICommonService
 * @description 公共服务接口
 * @auther wangsheng
 * @creatTime 2021/5/15 12:41 上午
 * @company
 * @department
 */
public interface ICommonService {
    /**
     * 生成客户ID
     *
     * @return
     */
    String getUserId();

    /**
     * 获取登录的用户信息
     *
     * @return
     */
    TblUser getLoginUser();

    /**
     * 分页查询公共方法
     *
     * @param dao         持久层bean
     * @param methodName  方法名称
     * @param pageRequest 查询条件
     * @return
     * @throws AppException
     */
    PageInfo<?> getPageInfo(Object dao, String methodName, PageRequest pageRequest) throws AppException;

    /**
     * 根据主键查询数据
     *
     * @param dao        持久层bean
     * @param methodName 方法名称
     * @param id         查询主键
     * @return
     * @throws AppException
     */
    <T> T getInfo(Object dao, String methodName, String id) throws AppException;

    /**
     * 使用反射给对象设置公共属性的值，请保证该对象一定包含该对象
     *
     * @param obj         要给公共属性设置值得对象
     * @param loginUserId 当前用户DI
     * @throws AppException
     */
    void setObjectUpdateInfo(Object obj, String loginUserId) throws AppException;

    /**
     * 使用反射给对象设置公共属性的值，请保证该对象一定包含该对象
     *
     * @param obj         要给公共属性设置值得对象
     * @param loginUserId 当前用户DI
     * @throws AppException
     */
    void setObjectInsertInfo(Object obj, String loginUserId) throws AppException;
}
