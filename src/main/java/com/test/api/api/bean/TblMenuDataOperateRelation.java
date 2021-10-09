package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_menu_data_operate_relation
 * 菜单数据操作关系表实体
 * @author 
 */
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

    public TblMenuDataOperateRelation() {
    }

    public TblMenuDataOperateRelation(String createUser, Date createTime, String updateUser, Date updateTime,
                                      String id, String menuId, String dataOperId, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.menuId = menuId;
        this.dataOperId = dataOperId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getDataOperId() {
        return dataOperId;
    }

    public void setDataOperId(String dataOperId) {
        this.dataOperId = dataOperId;
    }

    @Override
    public String toString() {
        return "TblMenuDataOperateRelation{" + JSONObject.toJSONString(this).toString() + "}";
    }
}