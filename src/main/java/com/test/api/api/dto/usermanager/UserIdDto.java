package com.test.api.api.dto.usermanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.usermanager
 * @className UserIdDto
 * @description 用户ID必填
 * @auther wangsheng
 * @creatTime 2021/11/7 12:37 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class UserIdDto implements Serializable {
    private static final long serialVersionUID = -6822524003247807075L;

    /**
     * 姓名
     */
    @NotNull(message = "用户ID不能为空")
    @NotBlank(message = "用户ID不能为空")
    private String id;
}
