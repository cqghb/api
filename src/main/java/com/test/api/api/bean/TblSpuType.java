package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_spu_type 货品类型实体类
 *
 * @author
 */
@Data
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

}