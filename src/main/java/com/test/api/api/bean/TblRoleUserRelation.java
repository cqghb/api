package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_role_user_relation
 * 角色用户关系实体
 * @author 
 */
@Data
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
}