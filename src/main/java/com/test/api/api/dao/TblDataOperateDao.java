package com.test.api.api.dao;

import com.test.api.api.bean.TblDataOperate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblDataOperateDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblDataOperate record);

    int insertSelective(TblDataOperate record);

    TblDataOperate selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblDataOperate record);

    int updateByPrimaryKey(TblDataOperate record);
}