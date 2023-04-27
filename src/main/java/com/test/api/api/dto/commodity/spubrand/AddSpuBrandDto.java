package com.test.api.api.dto.commodity.spubrand;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spubrand
 * @className AddSpuBrandDto
 * @description spu产品品牌新增表单对象
 * @auther wangsheng
 * @creatTime 2022/4/23 下午4:51
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class AddSpuBrandDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -6009777427245550875L;

    /**
     * 品牌名称
     */
    @NotNull(message = "品牌名称不能为空")
    @NotBlank(message = "品牌名称不能为空")
    private String name;

    /**
     * 品牌编码
     */
    @NotNull(message = "品牌编码不能为空")
    @NotBlank(message = "品牌编码不能为空")
    private String code;
}
