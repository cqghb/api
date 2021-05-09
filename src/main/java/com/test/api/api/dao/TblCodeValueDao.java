package com.test.api.api.dao;

import com.test.api.api.bean.TblCodeValue;
import com.test.api.api.bean.TblCodeValueKey;
import org.springframework.stereotype.Repository;

@Repository
public interface TblCodeValueDao {
    int deleteByPrimaryKey(TblCodeValueKey key);

    int insert(TblCodeValue record);

    int insertSelective(TblCodeValue record);

    TblCodeValue selectByPrimaryKey(TblCodeValueKey key);

    int updateByPrimaryKeySelective(TblCodeValue record);

    int updateByPrimaryKey(TblCodeValue record);
}