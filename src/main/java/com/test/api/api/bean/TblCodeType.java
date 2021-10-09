package com.test.api.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_code_type
 * 码值类型表
 * @author wsheng
 */
public class TblCodeType extends BaseBean implements Serializable {
    /**
     * 码类型
     */
    private String codeType;

    /**
     * 码类型中文
     */
    private String codeTypeName;

    public TblCodeType() {
    }

    public TblCodeType(String createUser, Date createTime, String updateUser, Date updateTime, String codeType,
                       String codeTypeName, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.codeType = codeType;
        this.codeTypeName = codeTypeName;
    }

    private static final long serialVersionUID = 1L;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeTypeName() {
        return codeTypeName;
    }

    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName;
    }

    @Override
    public String toString() {
        return "TblCodeType{" +
                "codeType='" + codeType + '\'' +
                ", codeTypeName='" + codeTypeName + '\'' +
                '}';
    }
}