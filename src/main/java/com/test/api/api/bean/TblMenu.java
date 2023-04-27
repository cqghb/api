package com.test.api.api.bean;

import lombok.Data;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblMenu
 * @description 菜单实体
 * @auther wangsheng
 * @creatTime 2020/11/7 7:22 下午
 * @company demo
 * @department demo
 */
@Data
public class TblMenu extends BaseBean implements java.io.Serializable {

    private static final long serialVersionUID = 4559101099074179257L;
    // 主键
    private String id;
    // 菜单名称
    private String name;
    // 菜单图标
    private String icon;
    // 父节点ID
    private String parentNode;
    // 是否默认选中
    private String defaultSelect;
    // 请求地址
    private String uri;
    // 是否是子菜单[1:是; 2:否;]
    private String childrenFlag;

    /** 以下是视图内容相关字段 **/
    // 默认选中的菜单
    List<String> defaultSelectList;
    // 子菜单
    List<TblMenu> childrenList;

   }
