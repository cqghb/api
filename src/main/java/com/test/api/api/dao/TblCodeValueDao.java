package com.test.api.api.dao;

import com.test.api.api.bean.TblCodeValue;
import com.test.api.api.bean.TblCodeValueKey;
import com.test.api.api.bo.CodeValueBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TblCodeValueDao {
    int deleteByPrimaryKey(TblCodeValueKey key);

    int insert(TblCodeValue record);

    int insertSelective(TblCodeValue record);

    TblCodeValue selectByPrimaryKey(TblCodeValueKey key);

    int updateByPrimaryKeySelective(TblCodeValue record);

    int updateByPrimaryKey(TblCodeValue record);

    /**
     * 键值对查询
     * @param codeValueBO 键类型
     * @return
     */
    List<Map<String, String>> searchCodeKeyValue(CodeValueBO codeValueBO);



}