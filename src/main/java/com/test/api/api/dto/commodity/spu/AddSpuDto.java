package com.test.api.api.dto.commodity.spu;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spu
 * @className AddSpuuDto
 * @description 添加货品表单对象
 * @auther wangsheng
 * @creatTime 2022/5/1 下午5:14
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class AddSpuDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 5227855759398736500L;

    /**
     * 货品名称
     */
    @NotNull(message = "货品名称不能为空")
    @NotBlank(message = "货品名称不能为空")
    private String name;

    /**
     * 货品编码
     */
    @NotNull(message = "货品编码不能为空")
    @NotBlank(message = "货品编码不能为空")
    private String code;

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
    @NotNull(message = "分类ID不能为空")
    @NotBlank(message = "分类ID不能为空")
    private String typeId;

    /**
     * 品牌ID
     */
    @NotNull(message = "品牌ID不能为空")
    @NotBlank(message = "品牌ID不能为空")
    private String brandId;

    public AddSpuDto() {
    }

    public AddSpuDto(String remark, String delTag,
                     @NotNull(message = "货品名称不能为空") @NotBlank(message = "货品名称不能为空") String name, @NotNull(message =
            "货品编码不能为空") @NotBlank(message = "货品编码不能为空") String code, String briefIntroduction, String detail,
                     @NotNull(message = "分类ID不能为空") @NotBlank(message = "分类ID不能为空") String typeId,
                     @NotNull(message = "品牌ID不能为空") @NotBlank(message = "品牌ID不能为空") String brandId) {
        super(remark, delTag);
        this.name = name;
        this.code = code;
        this.briefIntroduction = briefIntroduction;
        this.detail = detail;
        this.typeId = typeId;
        this.brandId = brandId;
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

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "AddSpuuDto{" + JSONObject.toJSONString(this) + "}";
    }
}
