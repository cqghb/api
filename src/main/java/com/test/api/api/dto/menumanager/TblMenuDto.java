package com.test.api.api.dto.menumanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblMenu
 * @description 菜单维护对象
 * @auther wangsheng
 * @creatTime 2020/11/7 7:22 下午
 * @company demo
 * @department demo
 */
@Data
public class TblMenuDto implements java.io.Serializable {

    // 主键
    @NotNull(message = "ID不能为空")
    @NotBlank(message = "ID姓名不能为空")
    private String id;
    // 菜单名称
    @NotNull(message = "菜单名称不能为空")
    @NotBlank(message = "菜单名称不能为空")
    private String name;
    // 菜单图标
    private String icon;
    // 父节点ID
    @NotNull(message = "父节点ID不能为空")
    @NotBlank(message = "父节点ID不能为空")
    private String parentNode;
    // 是否默认选中
    private String defaultSelect;

    // 请求地址
    private String uri;
    // 是否是子菜单[1:是; 2:否;]
    private String childrenFlag;
}
