package com.test.api.api.dto.commodity.property;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.property
 * @className AddTblPropertyDto
 * @description 添加产品属性表单对象
 * @auther wangsheng
 * @creatTime 2022/1/13 上午1:21
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class AddTblPropertyDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -2963571958367122051L;

    /**
     * 属性名称
     */
    @NotNull(message = "产品属性名称不能为空")
    @NotBlank(message = "产品属性名称不能为空")
    private String name;

    /**
     * 属性值
     */
    @NotNull(message = "属性值不能为空")
    @NotBlank(message = "属性值不能为空")
    private String value;
}
