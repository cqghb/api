package com.test.api.api.service;

import com.test.api.api.bean.TblUser;
import com.test.api.api.bo.UserBo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.apache.ibatis.cursor.Cursor;

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
     * @param id 用户编号
     * @param pass 密码
     * @return
     */
    TblUser login(String id, String pass);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 新增用户
     * @param user 用户
     * @return
     */
    String insert(UserBo user);

    /**
     * 删除用户
     * @param id 主键
     * @return
     */
    int deleteUser(String id);

    /**
     * 根据主键查询用户信息
     * @param id 用户主键
     * @return
     */
    TblUser queryUserById(String id);

    /**
     * 修改用户
     * @param user 用户
     * @return
     */
    int update(TblUser user);

    Cursor<TblUser> test();

    /**
     * 重置密码
     * @param user 密码登参数
     * @return
     */
    int resetPass(UserBo user);
}
