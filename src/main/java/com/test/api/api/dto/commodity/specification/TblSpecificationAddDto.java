package com.test.api.api.dto.commodity.specification;

import com.test.api.api.dto.BaseDto;
import com.test.api.api.dto.commodity.specificationoption.TblSpecificationOptionAddDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.specification
 * @className TblSpecificationAddDto
 * @description 添加货品规格表单对象
 * @auther wangsheng
 * @creatTime 2022/1/4 下午1:07
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblSpecificationAddDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -4940024653454849778L;

    /**
     * 分组名称
     */
    @NotNull(message = "分组名称不能为空")
    @NotBlank(message = "分组名称不能为空")
    private String name;

    /**
     * 显示位置
     */
    private Integer index;

    /**
     * 规格组零部件
     */
    private List<TblSpecificationOptionAddDto> componentArr;
}