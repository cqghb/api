package com.test.api.api.service.impl;

import com.test.api.api.bean.TblUser;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ITblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className TblUserService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/6 12:31 上午
 * @company demo
 * @department demo
 */
@Service
public class TblUserService implements ITblUserService {

    @Autowired
    private TblUserDao userDao;

    @Override
    public List<TblUser> queryList(TblUser user) {
        return userDao.select(user);
    }

    @Override
    public TblUser login(String id, String pass) {
        return userDao.login(id, pass);
    }
}
