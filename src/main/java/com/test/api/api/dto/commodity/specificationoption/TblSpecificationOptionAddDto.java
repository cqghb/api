package com.test.api.api.dto.commodity.specificationoption;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 商品规格选项信息
 * @author 
 */
@Data
public class TblSpecificationOptionAddDto extends BaseDto implements Serializable {
    /**
     * 规格选项ID
     */
    private String id;

    /**
     * 属性值
     */
    private String value;

    /**
     * 规格ID
     */
    private String specId;

    /**
     * 属性名
     */
    private String name;

    /**
     * 序号
     */
    private Integer index;

    private static final long serialVersionUID = 1L;
}