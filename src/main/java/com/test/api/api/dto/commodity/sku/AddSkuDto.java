package com.test.api.api.dto.commodity.sku;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

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
public class AddSkuDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = 8929755904824037428L;
    /**
     * SKU产品ID
     */
    private String id;

    /**
     * 产品名称
     */
    @NotNull(message = "产品名称不能为空")
    @NotBlank(message = "产品名称不能为空")
    private String name;

    /**
     * 产品编码
     */
    @NotNull(message = "产品编码不能为空")
    @NotBlank(message = "产品编码不能为空")
    private String code;

    /**
     * 产品价格
     */
    @NotNull(message = "产品价格不能为空")
    private BigDecimal price;

    /**
     * 产品数量
     */
    @NotNull(message = "产品数量不能为空")
    private int skuNumber;

    /**
     * SPU货品ID
     */
    @NotNull(message = "货品ID不能为空")
    @NotBlank(message = "货品ID不能为空")
    private String spuId;

    /**
     * 产品属性
     */
    @NotNull(message = "产品属性不能为空")
    private List<String> proOptId;

    /**
     * 产品规格
     */
    @NotNull(message = "产品规格不能为空")
    private List<String> specOptiIdArr;

    public AddSkuDto() {
    }

    public AddSkuDto(String remark, String delTag, String id, @NotNull(message = "产品名称不能为空") @NotBlank(message =
            "产品名称不能为空") String name, @NotNull(message = "产品编码不能为空") @NotBlank(message = "产品编码不能为空") String code,
                     @NotNull(message = "产品价格不能为空") BigDecimal price,
                     @NotNull(message = "产品数量不能为空") int skuNumber, @NotNull(message
            = "货品ID不能为空") @NotBlank(message = "货品ID不能为空") String spuId,
                     @NotNull(message = "产品属性不能为空") List<String> proOptId,
                     @NotNull(message = "产品规格不能为空") List<String> specOptiIdArr) {
        super(remark, delTag);
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.skuNumber = skuNumber;
        this.spuId = spuId;
        this.proOptId = proOptId;
        this.specOptiIdArr = specOptiIdArr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(int skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public List<String> getProOptId() {
        return proOptId;
    }

    public void setProOptId(List<String> proOptId) {
        this.proOptId = proOptId;
    }

    public List<String> getSpecOptiIdArr() {
        return specOptiIdArr;
    }

    public void setSpecOptiIdArr(List<String> specOptiIdArr) {
        this.specOptiIdArr = specOptiIdArr;
    }

    @Override
    public String toString() {
        return "AddSkuDto{" + JSONObject.toJSONString(this) + "}";
    }
}
