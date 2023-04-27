package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_image
 * @author 
 */
@Data
public class TblImage implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 商品主键
     */
    private String skuNo;

    /**
     * 序号
     */
    private Integer index;

    private static final long serialVersionUID = 1L;
}