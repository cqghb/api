package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_sku_after_sales
 * 商品售后信息
 * @author 
 */
@Data
public class TblSkuAfterSales implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 商品编号
     */
    private String skuNo;

    /**
     * 售后信息
     */
    private String afterSales;

    private static final long serialVersionUID = 1L;
}