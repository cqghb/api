package com.test.api.api.dto.commodity.sku;

import com.test.api.api.dto.BaseDto;
import com.test.api.api.dto.commodity.aftersales.TblSkuAfterSalesAddDto;
import com.test.api.api.dto.commodity.property.AddTblPropertyDto;
import com.test.api.api.dto.commodity.skuimage.TblImageAddDto;
import com.test.api.api.dto.commodity.specification.TblSpecificationAddDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spu
 * @className AddSkuDto
 * @description 添加产品表单对象
 * @auther wangsheng
 * @creatTime 2022/5/1 下午5:14
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class AddSkuDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = 8929755904824037428L;
    /**
     * 产品名称
     */
    @NotNull(message = "产品名称不能为空")
    @NotBlank(message = "产品名称不能为空")
    private String name;

    /**
     * 产品价格
     */
    @NotNull(message = "产品价格不能为空")
    private BigDecimal price;

    /**
     * 产品数量
     */
    @NotNull(message = "产品数量不能为空")
    private int number;

    /**
     * SPU货品ID
     */
    @NotNull(message = "货品编号不能为空")
    @NotBlank(message = "货品编号不能为空")
    private String spuNo;

    /**
     * 产品售后说明
     */
    private TblSkuAfterSalesAddDto skuAfterSales;

    /**
     * 产品基本属性
     */
    private List<AddTblPropertyDto> domains;
    /**
     * 商品规格组
     */
    private List<TblSpecificationAddDto> specificationPackage;

    /**
     * 产品图像信息
     */
    private List<TblImageAddDto> imageAddDtoList;



}
