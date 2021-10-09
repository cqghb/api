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


    public TblRole() {
    }

    public TblRole(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "TblRole{" + JSONObject.toJSONString(this).toString() + "}";
    }
}