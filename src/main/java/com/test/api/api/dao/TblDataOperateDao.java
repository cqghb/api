package com.test.api.api.dao;

import com.test.api.api.bean.TblDataOperate;
import org.springframework.stereotype.Repository;

@Repository
public interface TblDataOperateDao {
    int deleteByPrimaryKey(String id);

    int insert(TblDataOperate record);

    int insertSelective(TblDataOperate record);

    TblDataOperate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblDataOperate record);

    int updateByPrimaryKey(TblDataOperate record);
}