package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_data_operate
 * 数据操作实体
 * @author
 */
@Data
public class TblDataOperate extends BaseBean implements Serializable {
    private static final long serialVersionUID = 4544826577611310953L;
    /**
     * 主键
     */
    private String id;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 操作地址[地址要写全]
     */
    private String operateAddr;

    /**
     * 所属分组
     */
    private String subgroup;
}