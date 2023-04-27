package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_code_value
 * 码值表
 * @author wsheng
 */
@Data
public class TblCodeValue extends TblCodeValueKey implements Serializable {
    /**
     * 序号
     */
    private Integer index;

    private static final long serialVersionUID = 1L;
}