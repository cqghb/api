package com.test.api.api.dto.iconmanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.iconmanager
 * @className TblIconAddDto
 * @description 维护图标表单对象
 * @auther wangsheng
 * @creatTime 2021/12/8 上午1:30
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblIconUpdateDto implements Serializable {

    private static final long serialVersionUID = 5978366755544717701L;
    // 主键
    @NotNull(message = "主键不能为空")
    @NotBlank(message = "主键不能为空")
    private String id;
    // 图标中文名称
    private String name;

    @NotNull(message = "图标英文名称不能为空")
    @NotBlank(message = "图标英文名称不能为空")
    private String englishName;

    // 排序
    private int index;
}
