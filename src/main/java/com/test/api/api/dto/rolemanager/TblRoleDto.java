package com.test.api.api.dto.rolemanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemanager
 * @className TblRoleDto
 * @description 添加角色控制器对象
 * @auther wangsheng
 * @creatTime 2021/10/5 2:18 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblRoleDto implements Serializable {
    private static final long serialVersionUID = -6051306325137183341L;

    // TODO 验证部分后续修改成按操作来验证【使用自定义注解来实现】
    /**
     * ID
     */
    private String id;
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称不能为空")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    /**
     * 角色备注
     */
    private String remark;
}
