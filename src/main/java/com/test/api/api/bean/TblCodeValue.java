package com.test.api.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_code_value
 * 码值表
 * @author wsheng
 */
public class TblCodeValue extends TblCodeValueKey implements Serializable {
    /**
     * 序号
     */
    private Integer index;



    private static final long serialVersionUID = 1L;

    public TblCodeValue() {
    }

    public TblCodeValue(String createUser, Date createTime, String updateUser, Date updateTime, String codeType,
                        String code, String codeName, Integer index, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, codeType, code, codeName, remark, delTag);
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "TblCodeValue{" +
                "index=" + index +
                '}';
    }
}