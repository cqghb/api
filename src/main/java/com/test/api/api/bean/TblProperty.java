package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_property 产品属性实体
 *
 * @author
 */
public class TblProperty extends BaseBean implements Serializable {
    private static final long serialVersionUID = 2165301542993340644L;
    /**
     * 属性ID
     */
    private String id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 分类ID
     */
    private String typeId;

    public TblProperty() {
    }

    public TblProperty(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                       String delTag, String id, String name, String typeId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.typeId = typeId;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "TblProperty{" + JSONObject.toJSONString(this) + "}";
    }
}