package com.test.api.api.dto.commodity.aftersales;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import java.io.Serializable;

/**
 * tbl_sku_after_sales
 * 商品售后信息
 * @author 
 */
@Data
public class TblSkuAfterSalesAddDto extends BaseDto implements Serializable {
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