package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_sku_specification_option SKU-规格选项关联表实体
 *
 * @author
 */
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

    public TblSkuSpecificationOption() {
    }

    public TblSkuSpecificationOption(String createUser, Date createTime, String updateUser, Date updateTime,
                                     String remark, String delTag, String id, String skuId, String specOptiId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.skuId = skuId;
        this.specOptiId = specOptiId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSpecOptiId() {
        return specOptiId;
    }

    public void setSpecOptiId(String specOptiId) {
        this.specOptiId = specOptiId;
    }

    @Override
    public String toString() {
        return "TblSkuSpecificationOption{" + JSONObject.toJSONString(this) + "}";
    }
}