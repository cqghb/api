package com.test.api.api.dao;

import com.test.api.api.bean.TblImage;
import org.springframework.stereotype.Repository;

@Repository
public interface TblImageDao {
    int deleteByPrimaryKey(String id);

    int insert(TblImage record);

    int insertSelective(TblImage record);

    TblImage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblImage record);

    int updateByPrimaryKey(TblImage record);
}