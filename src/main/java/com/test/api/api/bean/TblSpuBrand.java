package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_spu_brand 商品品牌表实体
 *
 * @author wsheng
 */
@Data
public class TblSpuBrand extends BaseBean implements Serializable {

    private static final long serialVersionUID = -817195323831010505L;
    /**
     * 品牌ID
     */
    private String id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌编码
     */
    private String code;

}