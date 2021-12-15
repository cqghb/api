package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_spu_type 货品类型实体类
 *
 * @author
 */
public class TblSpuType extends BaseBean implements Serializable {
    private static final long serialVersionUID = 3106356125038175442L;
    /**
     * 货品类型ID
     */
    private String id;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 类型编码
     */
    private String code;

    public TblSpuType() {
    }

    public TblSpuType(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                      String delTag, String id, String name, String code) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TblSpuType{" + JSONObject.toJSONString(this) + "}";
    }
}