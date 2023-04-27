package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_spu
 * @author 
 */
@Data
public class TblSpu implements Serializable {
    /**
     * 货品ID
     */
    private String id;

    /**
     * 货品名称
     */
    private String name;

    /**
     * 货品编号
     */
    private String no;

    /**
     * 货品简介
     */
    private String briefIntroduction;

    /**
     * 货品详情
     */
    private String detail;

    /**
     * 分类ID
     */
    private String typeId;

    /**
     * 品牌ID
     */
    private String brandId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标志[1: 删除; 2: 保留]
     */
    private String delTag;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}