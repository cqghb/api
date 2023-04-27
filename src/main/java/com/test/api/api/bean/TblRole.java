package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_role
 * 角色实体
 * @author 
 */
@Data
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

}