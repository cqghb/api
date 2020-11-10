package com.test.api.api.dao;

import com.test.api.api.bean.TblUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblUserDao
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/6 12:32 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Repository
public interface TblUserDao {
    /**
     * 用户列表查询
     * @param user
     * @return
     */
    List<TblUser> select(TblUser user);

    /**
     * 用户登录
     * @param id 用户号
     * @param pass 密码
     * @return
     */
    TblUser login(@Param("id") String id, @Param("pass") String pass);
}
