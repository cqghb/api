package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_role_user_relation
 * 角色用户关系实体
 * @author 
 */
public class TblRoleUserRelation extends BaseBean implements Serializable {
    /**
     * 角色与用户关系ID
     */
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 用户ID
     */
    private String userId;

    public TblRoleUserRelation() {
    }

    public TblRoleUserRelation(String createUser, Date createTime, String updateUser, Date updateTime, String id, String roleId, String userId) {
        super(createUser, createTime, updateUser, updateTime);
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TblRoleUserRelation{" + JSONObject.toJSONString(this).toString() + "}";
    }
}