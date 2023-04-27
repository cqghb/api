package com.test.api.api.dto.commodity.spubrand;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spubrand
 * @className UpdateSpuBrandDto
 * @description 维护SPU品牌表单对象
 * @auther wangsheng
 * @creatTime 2022/4/23 下午4:56
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class UpdateSpuBrandDto extends AddSpuBrandDto implements Serializable {
    private static final long serialVersionUID = 8122275565816121190L;

    /**
     * 品牌ID
     */
    @NotNull(message = "品牌ID不能为空")
    @NotBlank(message = "品牌ID不能为空")
    private String id;
}
