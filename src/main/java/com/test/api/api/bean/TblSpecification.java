package com.test.api.api.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * tbl_specification
 * @author 
 */
@Data
@TableName("tbl_specification")
public class TblSpecification extends BaseBean implements Serializable {
    /**
     * 规格ID
     */
    @TableId
    private String id;

    /**
     * 分组名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 商品编号
     */
    @TableField(value = "sku_no")
    private String skuNo;

    /**
     * 显示位置
     * 字段名是关键字段的需要映射一下
     */
    @TableField(value = "`index`")
    private Integer index;

    private static final long serialVersionUID = 1L;
}