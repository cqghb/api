package com.test.api.api.dao;

import com.test.api.api.bean.TblSpecificationOption;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSpecificationOptionDao {
    int deleteByPrimaryKey(String id);

    int insert(TblSpecificationOption record);

    int insertSelective(TblSpecificationOption record);

    TblSpecificationOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpecificationOption record);

    int updateByPrimaryKey(TblSpecificationOption record);
}