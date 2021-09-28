package com.test.api.api.dao;

import com.test.api.api.bean.TblMenuDataOperateRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface TblMenuDataOperateRelationDao {
    int deleteByPrimaryKey(String id);

    int insert(TblMenuDataOperateRelation record);

    int insertSelective(TblMenuDataOperateRelation record);

    TblMenuDataOperateRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblMenuDataOperateRelation record);

    int updateByPrimaryKey(TblMenuDataOperateRelation record);
}