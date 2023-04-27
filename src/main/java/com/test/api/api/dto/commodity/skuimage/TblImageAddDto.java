package com.test.api.api.dto.commodity.skuimage;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import java.io.Serializable;

/**
 * tbl_image
 * 商品影像数据
 * @author 
 */
@Data
public class TblImageAddDto extends BaseDto implements Serializable {
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