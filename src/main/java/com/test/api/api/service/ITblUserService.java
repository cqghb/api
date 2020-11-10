package com.test.api.api.service;

import com.test.api.api.bean.TblUser;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblUserService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/6 12:31 上午
 * @company demo
 * @department demo
 */
public interface ITblUserService {

    /**
     * 用户列表查询
     * @param user
     * @return
     */
    List<TblUser> queryList(TblUser user);

    /**
     * 用户登录
     * @param id 用户号
     * @param pass 密码
     * @return
     */
    TblUser login(String id, String pass);

}
