package com.test.api.api.dao;

import com.test.api.api.bean.TblCodeType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblCodeTypeDao {
    int deleteByPrimaryKey(String codeType);

    int insert(TblCodeType record);

    int insertSelective(TblCodeType record);

    TblCodeType selectByPKDelTag(@Param("codeType") String codeType, @Param("delTag") String delTag);

    TblCodeType selectByPrimaryKey(String codeType);

    int updateByPrimaryKeySelective(TblCodeType record);

    int updateByPrimaryKey(TblCodeType record);
}