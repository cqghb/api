package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_property
 * @author 
 */
@Data
public class TblProperty extends BaseBean implements Serializable {
    /**
     * 属性ID
     */
    private String id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 商品编号
     */
    private String skuNo;

    /**
     * 属性值
     */
    private String value;

    private static final long serialVersionUID = 1L;
}