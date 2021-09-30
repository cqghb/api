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
     * @return
     */
    String getUserId();

    /**
     * 获取登录的用户信息
     * @return
     */
    TblUser getLoginUser();

    /**
     * 分页查询公共方法
     * @param pageRequest 查询条件
     * @return
     */
    PageInfo<?> getPageInfo(Object dao, String methodName, PageRequest pageRequest) throws AppException;
}
