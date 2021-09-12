package com.test.api.api.service;

import com.test.api.api.bean.TblUser;

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
}
