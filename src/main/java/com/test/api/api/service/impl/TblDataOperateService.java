package com.test.api.api.service.impl;

import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.dao.TblDataOperateDao;
import com.test.api.api.service.ITblDataOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblDataOperateService
 * @description 数据操作服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:02 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblDataOperateService implements ITblDataOperateService {

    @Autowired
    private TblDataOperateDao dataOperateDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return dataOperateDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblDataOperate record) {
        return dataOperateDao.insert(record);
    }

    @Override
    public int insertSelective(TblDataOperate record) {
        return dataOperateDao.insertSelective(record);
    }

    @Override
    public TblDataOperate selectByPrimaryKey(String id) {
        return dataOperateDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblDataOperate record) {
        return dataOperateDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblDataOperate record) {
        return dataOperateDao.updateByPrimaryKey(record);
    }
}
