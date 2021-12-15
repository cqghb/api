package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_spu 货品实体类
 *
 * @author
 */
public class TblSpu extends BaseBean implements Serializable {
    private static final long serialVersionUID = -6696216106874013819L;
    /**
     * 货品ID
     */
    private String id;

    /**
     * 货品名称
     */
    private String name;

    /**
     * 货品编码
     */
    private String code;

    /**
     * 货品简介
     */
    private String briefIntroduction;

    /**
     * 货品详情
     */
    private String detail;

    /**
     * 分类ID
     */
    private String typeId;

    /**
     * 品牌ID
     */
    private String brandId;

    public TblSpu() {
    }

    public TblSpu(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                  String delTag, String id, String name, String code, String briefIntroduction, String detail,
                  String typeId, String brandId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.code = code;
        this.briefIntroduction = briefIntroduction;
        this.detail = detail;
        this.typeId = typeId;
        this.brandId = brandId;
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

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "TblSpu{" + JSONObject.toJSONString(this) + "}";
    }
}