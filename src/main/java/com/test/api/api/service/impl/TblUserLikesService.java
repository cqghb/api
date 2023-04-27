package com.test.api.api.service.impl;

import com.test.api.api.bean.TblUserLikes;
import com.test.api.api.dao.TblUserLikesDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblUserLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblUserLikesService
 * @description 用户喜好服务实现类
 * @auther wangsheng
 * @creatTime 2021/5/10 12:31 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblUserLikesService implements ITblUserLikesService {

    @Autowired
    private TblUserLikesDao userLikesDao;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userLikesDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByUserId(String userId) {
        return userLikesDao.deleteByUserId(userId);
    }

    @Override
    public int insert(TblUserLikes record) {
        return userLikesDao.insert(record);
    }

    @Override
    public int insertSelective(TblUserLikes record) {
        return userLikesDao.insertSelective(record);
    }

    @Override
    public TblUserLikes selectByPrimaryKey(String id) {
        return userLikesDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblUserLikes record) {
        return userLikesDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblUserLikes record) {
        return userLikesDao.updateByPrimaryKey(record);
    }

    @Override
    public List<String> queryUserLikeIds(String userId) {
        return userLikesDao.queryUserLikeIds(userId);
    }
}
