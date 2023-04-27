package com.test.api.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto
 * @className CommonIdDto
 * @description 根据ID参数删除数据的公共参数对象
 * @auther wangsheng
 * @creatTime 2021/10/7 12:10 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class CommonIdDto implements Serializable {
    private static final long serialVersionUID = 4569587853145538722L;

    /**
     * 角色名称
     */
    @NotNull(message = "ID不能为空")
    @NotBlank(message = "ID不能为空")
    private String id;

}
