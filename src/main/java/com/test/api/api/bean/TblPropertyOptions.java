package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_property_options 属性选项实体
 *
 * @author
 */
@Data
public class TblPropertyOptions extends BaseBean implements Serializable {
    private static final long serialVersionUID = 8539067189142192120L;
    /**
     * 属性选项ID
     */
    private String id;

    /**
     * 选项值
     */
    private String value;

    /**
     * 属性ID
     */
    private String attrId;
}