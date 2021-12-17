package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_specification_option 产品规格选项表实体类
 *
 * @author
 */
public class TblSpecificationOption extends BaseBean implements Serializable {
    private static final long serialVersionUID = -5169631099866597898L;
    /**
     * 规格选项ID
     */
    private String id;

    /**
     * 选项值
     */
    private String value;

    /**
     * 规格ID
     */
    private String specId;

    public TblSpecificationOption() {
    }

    public TblSpecificationOption(String createUser, Date createTime, String updateUser, Date updateTime,
                                  String remark, String delTag, String id, String value, String specId) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.value = value;
        this.specId = specId;
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

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Override
    public String toString() {
        return "TblSpecificationOption{" + JSONObject.toJSONString(this) + "}";
    }
}