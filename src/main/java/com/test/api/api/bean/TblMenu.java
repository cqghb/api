package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
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

    public TblMenu() {
    }

    public TblMenu(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name,
                   String icon, String parentNode, String defaultSelect, String uri, List<String> defaultSelectList,
                   List<TblMenu> childrenList, String remark, String delTag, String childrenFlag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.parentNode = parentNode;
        this.defaultSelect = defaultSelect;
        this.uri = uri;
        this.childrenFlag = childrenFlag;
        this.defaultSelectList = defaultSelectList;
        this.childrenList = childrenList;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<String> getDefaultSelectList() {
        return defaultSelectList;
    }

    public void setDefaultSelectList(List<String> defaultSelectList) {
        this.defaultSelectList = defaultSelectList;
    }

    public List<TblMenu> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<TblMenu> childrenList) {
        this.childrenList = childrenList;
    }

    public String getChildrenFlag() {
        return childrenFlag;
    }

    public void setChildrenFlag(String childrenFlag) {
        this.childrenFlag = childrenFlag;
    }

    @Override
    public String toString() {
        return "TblMenu{" + JSONObject.toJSONString(this) + "}";
    }
}
