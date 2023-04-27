package com.test.api.api.dto.commodity.specification;

import com.test.api.api.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.specification
 * @className TblSpecificationUpdateDto
 * @description 维护货品规格表单对象
 * @auther wangsheng
 * @creatTime 2022/1/6 上午12:44
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblSpecificationUpdateDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -304786487763213440L;
    /**
     * 规格ID
     */
    @NotNull(message = "产品规格ID不能为空")
    @NotBlank(message = "产品规格ID不能为空")
    private String id;

    /**
     * 参数名称
     */
    @NotNull(message = "产品规格名称不能为空")
    @NotBlank(message = "产品规格名称不能为空")
    private String name;

    /**
     * 规格组ID
     */
    @NotNull(message = "产品规格规格组ID不能为空")
    @NotBlank(message = "产品规格规格组ID不能为空")
    private String groupId;

    /**
     * 分类ID
     */
    @NotNull(message = "产品规格分类ID不能为空")
    @NotBlank(message = "产品规格分类ID不能为空")
    private String typeId;
    /**
     * 显示位置
     */
    private String addr;
}
