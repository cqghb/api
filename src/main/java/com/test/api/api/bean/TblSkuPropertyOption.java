package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_sku_property_option SKU-属性选项关联表
 *
 * @author
 */
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


    public TblSkuPropertyOption() {
    }

    public TblSkuPropertyOption(String createUser, Date createTime, String updateUser, Date updateTime,
                                String remark, String delTag, String id, String skuId, String proOptId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.skuId = skuId;
        this.proOptId = proOptId;
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

    public String getProOptId() {
        return proOptId;
    }

    public void setProOptId(String proOptId) {
        this.proOptId = proOptId;
    }

    @Override
    public String toString() {
        return "TblSkuPropertyOption{" + JSONObject.toJSONString(this) + "}";
    }
}