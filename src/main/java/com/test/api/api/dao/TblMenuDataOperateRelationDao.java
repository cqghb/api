package com.test.api.api.dao;

import com.test.api.api.bean.TblMenuDataOperateRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblMenuDataOperateRelationDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblMenuDataOperateRelation record);

    int insertSelective(TblMenuDataOperateRelation record);

    TblMenuDataOperateRelation selectByPrimaryKey(@Param("id") String id, @Param("delTag") String delTag);

    int updateByPrimaryKeySelective(TblMenuDataOperateRelation record);

    int updateByPrimaryKey(TblMenuDataOperateRelation record);

    /**
     * 根据菜单ID删除菜单数据操作权限
     * @param dataOperateRelation
     * @return
     */
    int deleteByMenuId(TblMenuDataOperateRelation dataOperateRelation);
}