package com.test.api.api.service.impl;

import com.test.api.api.bean.TblMenuDataOperateRelation;
import com.test.api.api.dao.TblMenuDataOperateRelationDao;
import com.test.api.api.service.ITblMenuDataOperateRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblMenuDataOperateRelationService
 * @description 菜单数据操作权限关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:05 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblMenuDataOperateRelationService implements ITblMenuDataOperateRelationService {

    @Autowired
    private TblMenuDataOperateRelationDao menuDataOperateRelationDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuDataOperateRelationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.insert(record);
    }

    @Override
    public int insertSelective(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.insertSelective(record);
    }

    @Override
    public TblMenuDataOperateRelation selectByPrimaryKey(String id) {
        return menuDataOperateRelationDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.updateByPrimaryKey(record);
    }
}
