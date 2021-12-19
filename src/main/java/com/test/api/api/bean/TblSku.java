package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * tbl_sku 产品表实体
 *
 * @author
 */
public class TblSku extends BaseBean implements Serializable {
    private static final long serialVersionUID = 3865294686364389065L;
    /**
     * SKU产品ID
     */
    private String id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编码
     */
    private String code;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * SPU货品ID
     */
    private String spuId;

    public TblSku() {
    }

    public TblSku(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                  String delTag, String id, String name, String code, BigDecimal price, String spuId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.spuId = spuId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    @Override
    public String toString() {
        return "TblSku{" + JSONObject.toJSONString(this) + "}";
    }
}