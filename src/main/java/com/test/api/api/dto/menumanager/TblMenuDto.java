package com.test.api.api.dto.menumanager;

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

    public TblMenuDto() {
    }

    public TblMenuDto(@NotNull(message = "ID不能为空") @NotBlank(message = "ID姓名不能为空") String id, @NotNull(message = "菜单名称不能为空") @NotBlank(message = "菜单名称不能为空") String name, String icon, @NotNull(message = "父节点ID不能为空") @NotBlank(message = "父节点ID不能为空") String parentNode, String defaultSelect) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.parentNode = parentNode;
        this.defaultSelect = defaultSelect;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getDefaultSelect() {
        return defaultSelect;
    }

    public void setDefaultSelect(String defaultSelect) {
        this.defaultSelect = defaultSelect;
    }

    @Override
    public String toString() {
        return "TblMenu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parentNode='" + parentNode + '\'' +
                ", defaultSelect='" + defaultSelect + '\'' +
                '}';
    }
}
