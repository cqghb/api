package com.test.api.api.dao;

import com.test.api.api.bean.TblSpecification;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSpecificationDao {
    int deleteByPrimaryKey(String id);

    int insert(TblSpecification record);

    int insertSelective(TblSpecification record);

    TblSpecification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpecification record);

    int updateByPrimaryKey(TblSpecification record);
}