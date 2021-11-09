package com.test.api.api.dao;

import com.test.api.api.bean.TblRole;
import com.test.api.api.bean.TblRoleUserRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblRoleUserRelationDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblRoleUserRelation record);

    int insertSelective(TblRoleUserRelation record);

    TblRoleUserRelation selectByPrimaryKey(@Param("id") String id, @Param("delTag") String delTag);

    int updateByPrimaryKeySelective(TblRoleUserRelation record);

    int updateByPrimaryKey(TblRoleUserRelation record);

    /**
     * 根据用户ID查询用户角色
     *
     * @param userId 用户ID
     * @param delTag 删除标记
     * @return
     */
    List<TblRole> queryUserRoleByUserId(@Param("userId") String userId, @Param("delTag") String delTag);

    /**
     * 根据用户主键逻辑逻辑删除用户角色关系
     * @param userRoleRelation
     */
    void deleteByUserId(TblRoleUserRelation userRoleRelation);
}