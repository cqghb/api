package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_property_options 属性选项实体
 *
 * @author
 */
public class TblPropertyOptions extends BaseBean implements Serializable {
    private static final long serialVersionUID = 8539067189142192120L;
    /**
     * 属性选项ID
     */
    private String id;

    /**
     * 选项值
     */
    private String value;

    /**
     * 属性ID
     */
    private String attrId;

    public TblPropertyOptions() {
    }

    public TblPropertyOptions(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                              String delTag, String id, String value, String attrId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.value = value;
        this.attrId = attrId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    @Override
    public String toString() {
        return "TblPropertyOptions{" + JSONObject.toJSONString(this) + "}";
    }
}