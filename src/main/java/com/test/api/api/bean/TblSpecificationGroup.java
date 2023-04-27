package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_specification_group 产品规格分组表实体
 *
 * @author
 */
@Data
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

}