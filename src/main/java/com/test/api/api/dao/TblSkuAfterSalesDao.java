package com.test.api.api.dao;

import com.test.api.api.bean.TblSkuAfterSales;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSkuAfterSalesDao {
    int deleteByPrimaryKey(String id);

    int insert(TblSkuAfterSales record);

    int insertSelective(TblSkuAfterSales record);

    TblSkuAfterSales selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSkuAfterSales record);

    int updateByPrimaryKey(TblSkuAfterSales record);
}