package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_data_operate
 * 数据操作实体
 * @author
 */
public class TblDataOperate extends BaseBean implements Serializable {
    private static final long serialVersionUID = 4544826577611310953L;
    /**
     * 主键
     */
    private String id;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 操作地址[地址要写全]
     */
    private String operateAddr;

    public TblDataOperate() {
    }

    public TblDataOperate(String createUser, Date createTime, String updateUser, Date updateTime, String id,
                          String name, String operateAddr, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.operateAddr = operateAddr;
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

    public String getOperateAddr() {
        return operateAddr;
    }

    public void setOperateAddr(String operateAddr) {
        this.operateAddr = operateAddr;
    }

    @Override
    public String toString() {
        return "TblDataOperate{" + JSONObject.toJSONString(this).toString() + "}";
    }
}