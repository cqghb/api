package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_specification_group 产品规格分组表实体
 *
 * @author
 */
public class TblSpecificationGroup extends BaseBean implements Serializable {
    private static final long serialVersionUID = -7422323787279915112L;
    /**
     * 规格组ID
     */
    private String id;

    /**
     * 规格组名称
     */
    private String name;

    public TblSpecificationGroup() {
    }

    public TblSpecificationGroup(String createUser, Date createTime, String updateUser, Date updateTime,
                                 String remark, String delTag, String id, String name) {
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
        return "TblSpecificationGroup{" + JSONObject.toJSONString(this) + "}";
    }
}