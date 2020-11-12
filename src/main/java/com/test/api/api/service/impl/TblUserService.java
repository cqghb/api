package com.test.api.api.service.impl;

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

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<TblUser> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TblUser> sysMenus = userDao.queryList(null);
        return new PageInfo<TblUser>(sysMenus);
    }
}
