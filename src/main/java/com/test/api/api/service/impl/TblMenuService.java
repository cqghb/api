package com.test.api.api.service.impl;

import com.test.api.api.bean.TblMenu;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.dao.TblMenuDao;
import com.test.api.api.service.ITblMenuService;
import com.test.api.api.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblMenuService
 * @description 菜单服务实现类
 * @auther wangsheng
 * @creatTime 2020/11/7 8:07 下午
 * @company demo
 * @department demo
 */
@Service
public class TblMenuService implements ITblMenuService {

    @Autowired
    private TblMenuDao menuDao;

    @Override
    public MenuTree queryMenu() {
        MenuTree menuTree = new MenuTree();
        // 根菜单
        List<TblMenu> rootTree = new ArrayList<>();
        List<TblMenu> allMenuList = menuDao.queryList(null);
        // 获取根菜单
        for(TblMenu item : allMenuList){
            String parentNode = item.getParentNode();
            if(CommConstant.MENU_PRENT_NODE.equals(parentNode)){
                rootTree.add(item);
            }
        }
        // 查根菜单的子菜单
        for(TblMenu item : rootTree){
            String id = item.getId();
            List<TblMenu> childrenTree = this.getChildren(id, allMenuList);
            item.setChildrenList(childrenTree);
        }
        menuTree.setRootTree(rootTree);
        // 查询默认选中的菜单
        List<String> defaultSelect = menuDao.queryDefaultSelect();
        menuTree.setDefaultSelectList(defaultSelect);
        return menuTree;
    }


    private List<TblMenu> getChildren(String parentId, List<TblMenu> allTree){
        List<TblMenu> childrenTree = new ArrayList<>();
        for(TblMenu item : allTree){
            if(parentId.equals(item.getParentNode())){
                childrenTree.add(item);
            }
        }
        for (TblMenu item : childrenTree){
            item.setChildrenList(getChildren(item.getId(), allTree));
        }
        return childrenTree;
    }
}
