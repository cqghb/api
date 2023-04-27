package com.test.api.api.dao;

import com.test.api.api.bean.TblSku;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSkuDao {
    int deleteByPrimaryKey(String id);

    int insert(TblSku record);

    int insertSelective(TblSku record);

    TblSku selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSku record);

    int updateByPrimaryKey(TblSku record);
}