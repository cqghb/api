package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_role_menu_relation
 * 角色菜单关系实体
 * @author 
 */
@Data
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
}