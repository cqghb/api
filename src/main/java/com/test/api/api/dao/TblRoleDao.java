package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblRoleDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblRole record);

    int insertSelective(TblRole record);

    TblRole selectByPrimaryKey(@Param("id") String id, @Param("delTag") String delTag);

    int updateByPrimaryKeySelective(TblRole record);

    int updateByPrimaryKey(TblRole record);

    /**
     * 列表查询
     * @param record 查询条件
     * @return
     */
    List<TblRole> queryList(JSONObject record);

    /**
     * 修改角色删除标志
     * @param record 角色对象
     * @return
     */
    int updateRoleDelTag(TblRole record);
}