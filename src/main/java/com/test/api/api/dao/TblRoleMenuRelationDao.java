package com.test.api.api.dao;

import com.test.api.api.bean.TblRoleMenuRelation;
import com.test.api.api.vo.rolemenurelation.RoleMenuRelationVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据角色主键查询所有角色菜单
     * @param roleId 角色主键
     * @return
     */
    List<RoleMenuRelationVO> queryRoleMenu(@Param("roleId") String roleId);
}