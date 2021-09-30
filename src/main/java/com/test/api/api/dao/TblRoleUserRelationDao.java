package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleUserRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleUserRelationDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblRoleUserRelation record);

    int insertSelective(TblRoleUserRelation record);

    TblRoleUserRelation selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblRoleUserRelation record);

    int updateByPrimaryKey(TblRoleUserRelation record);
}