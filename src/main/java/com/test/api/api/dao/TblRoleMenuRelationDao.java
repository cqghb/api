package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleMenuRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleMenuRelationDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblRoleMenuRelation record);

    int insertSelective(TblRoleMenuRelation record);

    TblRoleMenuRelation selectByPrimaryKey(@Param("id") String id, @Param("delTag") String delTag);

    int updateByPrimaryKeySelective(TblRoleMenuRelation record);

    int updateByPrimaryKey(TblRoleMenuRelation record);

    /**
     * 根据角色ID逻辑删除角色菜单关系
     * @param roleMenuRelation
     * @return
     */
    int deleteByRoleId(TblRoleMenuRelation roleMenuRelation);
}