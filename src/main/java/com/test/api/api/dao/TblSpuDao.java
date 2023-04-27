package com.test.api.api.dao;

import com.test.api.api.bean.TblSpu;

public interface TblSpuDao {
    int deleteByPrimaryKey(String id);

    int insert(TblSpu record);

    int insertSelective(TblSpu record);

    TblSpu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpu record);

    int updateByPrimaryKey(TblSpu record);
}