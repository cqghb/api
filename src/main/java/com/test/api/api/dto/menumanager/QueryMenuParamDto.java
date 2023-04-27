package com.test.api.api.dto.menumanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.menumanager
 * @className TblMenuDelDto
 * @description 删除菜单参数
 * @auther wangsheng
 * @creatTime 2021/9/14 12:53 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class QueryMenuParamDto implements Serializable {
    private static final long serialVersionUID = -8751835891322753595L;

    @NotBlank(message = "ID不能为空")
    private String id;
}
