package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_sku_property_option SKU-属性选项关联表
 *
 * @author
 */
@Data
public class TblSkuPropertyOption extends BaseBean implements Serializable {
    private static final long serialVersionUID = -8797678372589243034L;
    /**
     * SKU-属性选项关联ID
     */
    private String id;

    /**
     * SKU ID
     */
    private String skuId;

    /**
     * 属性选项ID
     */
    private String proOptId;

}