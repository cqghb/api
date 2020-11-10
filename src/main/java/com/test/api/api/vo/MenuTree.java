package com.test.api.api.vo;

import com.test.api.api.bean.TblMenu;

import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className MenuTree
 * @description 菜单树
 * @auther wangsheng
 * @creatTime 2020/11/7 7:54 下午
 * @company demo
 * @department demo
 */
public class MenuTree implements java.io.Serializable {

    // 默认选中的菜单
    List<String> defaultSelectList;
    // 子菜单
    List<TblMenu> rootTree;

    public MenuTree() {
    }

    public MenuTree(List<String> defaultSelectList, List<TblMenu> rootTree) {
        this.defaultSelectList = defaultSelectList;
        this.rootTree = rootTree;
    }

    public List<String> getDefaultSelectList() {
        return defaultSelectList;
    }

    public void setDefaultSelectList(List<String> defaultSelectList) {
        this.defaultSelectList = defaultSelectList;
    }

    public List<TblMenu> getRootTree() {
        return rootTree;
    }

    public void setRootTree(List<TblMenu> rootTree) {
        this.rootTree = rootTree;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "defaultSelectList=" + defaultSelectList +
                ", rootTree=" + rootTree +
                '}';
    }
}
