package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_role_menu_relation
 * 角色菜单关系实体
 * @author 
 */
public class TblRoleMenuRelation extends BaseBean implements Serializable {
    private static final long serialVersionUID = 5954346463504179628L;
    /**
     * 角色与菜单关系ID
     */
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

    public TblRoleMenuRelation() {
    }

    public TblRoleMenuRelation(String createUser, Date createTime, String updateUser, Date updateTime, String id, String roleId, String menuId) {
        super(createUser, createTime, updateUser, updateTime);
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "TblRoleMenuRelation{" + JSONObject.toJSONString(this).toString() + "}";

    }
}