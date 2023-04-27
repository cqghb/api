package com.test.api.api.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * tbl_sku 产品持久化对象
 * @author 
 */
@Data
@TableName("tbl_sku")
public class TblSku extends BaseBean implements Serializable {
    /**
     * SKU产品ID
     */
    @TableId
    private String id;

    /**
     * 产品名称
     */
    @TableField("name")
    private String name;

    /**
     * 产品价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * SPU货品ID
     */
    @TableField("spu_no")
    private String spuNo;

    /**
     * 版本
     */
    @TableField("version")
    private String version;

    /**
     * 商品编号
     */
    @TableField("no")
    private String no;

    /**
     * 数量
     */
    @TableField("number")
    private Integer number;

    private static final long serialVersionUID = 1L;
}