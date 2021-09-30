package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleMenuRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleMenuRelationDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblRoleMenuRelation record);

    int insertSelective(TblRoleMenuRelation record);

    TblRoleMenuRelation selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblRoleMenuRelation record);

    int updateByPrimaryKey(TblRoleMenuRelation record);
}