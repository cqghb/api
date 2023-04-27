package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_sku_specification_option SKU-规格选项关联表实体
 *
 * @author
 */
@Data
public class TblSkuSpecificationOption extends BaseBean implements Serializable {
    private static final long serialVersionUID = 5649941645974653238L;
    /**
     * ID
     */
    private String id;

    /**
     * SKU ID
     */
    private String skuId;

    /**
     * 规格选项ID
     */
    private String specOptiId;

}