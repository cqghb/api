package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleUserRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleUserRelationDao {
    int deleteByPrimaryKey(String id);

    int insert(TblRoleUserRelation record);

    int insertSelective(TblRoleUserRelation record);

    TblRoleUserRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblRoleUserRelation record);

    int updateByPrimaryKey(TblRoleUserRelation record);
}