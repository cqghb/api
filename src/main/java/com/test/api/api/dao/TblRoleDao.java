package com.test.api.api.dao;

import com.test.api.api.bean.TblRole;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(TblRole record);

    int insertSelective(TblRole record);

    TblRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblRole record);

    int updateByPrimaryKey(TblRole record);
}