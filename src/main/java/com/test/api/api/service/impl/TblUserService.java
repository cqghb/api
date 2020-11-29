package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblUser;
import com.test.api.api.dao.TblUserDao;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
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
        return userDao.queryList(user);
    }

    @Override
    public TblUser login(String id, String pass) {
        return userDao.login(id, pass);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public int insert(TblUser user) {
        return userDao.insert(user);
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public TblUser queryUserById(String id) {
        return userDao.queryUserById(id);
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
        List<TblUser> usetList = userDao.queryList(params);
        return new PageInfo<TblUser>(usetList);
    }
}
