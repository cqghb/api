package com.test.api.api.dao;

import com.test.api.api.bean.TblProperty;
import org.springframework.stereotype.Repository;

@Repository
public interface TblPropertyDao {
    int deleteByPrimaryKey(String id);

    int insert(TblProperty record);

    int insertSelective(TblProperty record);

    TblProperty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblProperty record);

    int updateByPrimaryKey(TblProperty record);
}