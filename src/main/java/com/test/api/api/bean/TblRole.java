package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_role
 * 角色实体
 * @author 
 */
public class TblRole extends BaseBean implements Serializable {
    private static final long serialVersionUID = 2943015412318650123L;
    /**
     * 角色主键
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;
    /**
     * 删除标志
     */
    private String delTag;
    /**
     * 备注
     */
    private String remark;

    public TblRole() {
    }

    public TblRole(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name, String delTag, String remark) {
        super(createUser, createTime, updateUser, updateTime);
        this.id = id;
        this.name = name;
        this.delTag = delTag;
        this.remark = remark;
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

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TblRole{" + JSONObject.toJSONString(this).toString() + "}";
    }
}