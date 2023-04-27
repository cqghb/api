package com.test.api.api.dto.commodity.sputype;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.sputype
 * @className UpdateTblSpuTypeDto
 * @description 维护货品类型表单对象
 * @auther wangsheng
 * @creatTime 2022/1/9 下午12:08
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class UpdateTblSpuTypeDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -4134361924141588758L;

    /**
     * 货品类型主键
     */
    @NotNull(message = "ID不能为空")
    @NotBlank(message = "ID不能为空")
    private String id;

    /**
     * 货品类型名称
     */
    @NotNull(message = "货品类型名称不能为空")
    @NotBlank(message = "货品类型名称不能为空")
    private String name;

    /**
     * 货品类型编码
     */
    @NotNull(message = "货品类型编码不能为空")
    @NotBlank(message = "货品类型编码不能为空")
    private String code;
}
