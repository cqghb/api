package com.test.api.api.dto.rolemenurelation;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemenurelation
 * @className RoleMenuRelationSettingDto
 * @description 角色菜单权限设置表单对象
 * @auther wangsheng
 * @creatTime 2021/10/14 1:16 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class RoleMenuRelationSettingDto implements Serializable {

    private static final long serialVersionUID = 2670947224048677039L;
    /**
     * 菜单主键
     */
    @NotNull(message = "菜单主键不能为空")
    @NotBlank(message = "菜单主键不能为空")
    private String roleId;
    /**
     * 数据操作ID列表
     */
    private String[] menuIdList;
}
