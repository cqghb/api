package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_specification 产品规格表实体
 *
 * @author
 */
public class TblSpecification extends BaseBean implements Serializable {
    private static final long serialVersionUID = -4117968001445917909L;
    /**
     * 规格ID
     */
    private String id;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 规格组ID
     */
    private String groupId;

    /**
     * 分类ID
     */
    private String typeId;

    /**
     * 显示位置
     */
    private String addr;

    public TblSpecification() {
    }

    public TblSpecification(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                            String delTag, String id, String name, String groupId, String typeId, String addr) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.typeId = typeId;
        this.addr = addr;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "TblSpecification{" + JSONObject.toJSONString(this) + "}";
    }
}