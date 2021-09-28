package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleMenuRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleMenuRelationDao {
    int deleteByPrimaryKey(String id);

    int insert(TblRoleMenuRelation record);

    int insertSelective(TblRoleMenuRelation record);

    TblRoleMenuRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblRoleMenuRelation record);

    int updateByPrimaryKey(TblRoleMenuRelation record);
}