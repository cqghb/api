package com.test.api.api.dto.commodity.spu;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

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
@Data
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
}
