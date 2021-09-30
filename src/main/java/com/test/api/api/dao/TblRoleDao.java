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

    TblRole selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblRole record);

    int updateByPrimaryKey(TblRole record);

    List<TblRole> queryList(JSONObject record);
}