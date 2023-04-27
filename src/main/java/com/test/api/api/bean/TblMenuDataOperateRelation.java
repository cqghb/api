package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_menu_data_operate_relation
 * 菜单数据操作关系表实体
 * @author 
 */
@Data
public class TblMenuDataOperateRelation extends BaseBean implements Serializable {
    private static final long serialVersionUID = -54173437093020113L;
    /**
     * 菜单与操作关系主键
     */
    private String id;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 数据操作ID
     */
    private String dataOperId;
}