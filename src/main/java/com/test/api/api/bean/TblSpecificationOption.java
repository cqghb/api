package com.test.api.api.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * tbl_specification_option
 * @author 
 */
@Data
@TableName("tbl_specification_option")
public class TblSpecificationOption extends BaseBean implements Serializable {
    /**
     * 规格选项ID
     */
    @TableId
    private String id;

    /**
     * 属性值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 规格ID
     */
    @TableField(value = "spec_id")
    private String specId;

    /**
     * 属性名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 序号
     */
    @TableField(value = "`index`")
    private Integer index;

    private static final long serialVersionUID = 1L;
}