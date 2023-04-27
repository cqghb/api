package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_code_type
 * 码值类型表
 * @author wsheng
 */
@Data
public class TblCodeType extends BaseBean implements Serializable {
    /**
     * 码类型
     */
    private String codeType;

    /**
     * 码类型中文
     */
    private String codeTypeName;
}