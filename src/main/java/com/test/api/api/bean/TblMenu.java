package com.test.api.api.bean;

import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblMenu
 * @description 菜单实体
 * @auther wangsheng
 * @creatTime 2020/11/7 7:22 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblMenu extends BaseBean implements java.io.Serializable {

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

    /** 以下是视图内容相关字段 **/
    // 默认选中的菜单
    List<String> defaultSelectList;
    // 子菜单
    List<TblMenu> childrenList;

    public TblMenu() {
    }

    public TblMenu(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name, String icon, String parentNode, String defaultSelect, String uri, List<String> defaultSelectList, List<TblMenu> childrenList) {
        super(createUser, createTime, updateUser, updateTime);
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.parentNode = parentNode;
        this.defaultSelect = defaultSelect;
        this.uri = uri;
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

    @Override
    public String toString() {
        return "TblMenu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parentNode='" + parentNode + '\'' +
                ", defaultSelect='" + defaultSelect + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
