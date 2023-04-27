package com.test.api.api.dto.commodity.specificationgroup;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity
 * @className TblSpecificationGroupAddDto
 * @description 产品规格分组创建表单对象
 * @auther wangsheng
 * @creatTime 2021/12/31 上午12:04
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblSpecificationGroupAddDto implements Serializable {
    private static final long serialVersionUID = 5878357595139091045L;
    /**
     * 规格组ID
     */
    private String id;

    /**
     * 规格组名称
     */
    @NotNull(message = "规格组名称不能为空")
    @NotBlank(message = "规格组名称不能为空")
    private String name;

    /**
     * 备注
     */
    private String remark;
}
