package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblMenu;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.dao.TblMenuDao;
import com.test.api.api.dto.menumanager.QueryParentMenuParamsDto;
import com.test.api.api.dto.menumanager.TblMenuDto;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblMenuService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.MenuTree;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private ICommonService commonService;

    @Override
    public MenuTree queryMenu() {
        MenuTree menuTree = new MenuTree();
        // 根菜单
        List<TblMenu> rootTree = this.treeMenu(null);
        menuTree.setRootTree(rootTree);
        // 查询默认选中的菜单
        List<String> defaultSelect = menuDao.queryDefaultSelect();
        menuTree.setDefaultSelectList(defaultSelect);
        return menuTree;
    }

    @Override
    public PageResult queryMenuList(PageRequest pageQuery) {
        // parentList 只有根节点数据
        PageInfo<TblMenu> pageInfo = this.getPageInfo(pageQuery);
        List<TblMenu> parentList = pageInfo.getList();
        // 查根菜单的子菜单
        List<TblMenu> treeList = this.getChildren(parentList);
        pageInfo.setList(treeList);
        return PageUtils.getPageResult(pageInfo);
    }

    @Override
    public int insertSelective(TblMenu menu) {
        TblUser loginUser = commonService.getLoginUser();
        String loginUserId = loginUser.getId();
        menu.setId(StringUtil.uuid());
        menu.setCreateUser(loginUserId);
        return menuDao.insertSelective(menu);
    }

    @Override
    public int deleteById(String id) throws AppException {
        // 检查原数据是否还存在
        TblMenu menu = menuDao.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(menu)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_INFO_IS_NULL);
        }
        // 检查是否有子节点
        TblMenu queryParam = new TblMenu();
        queryParam.setParentNode(id);
        List<TblMenu> childrenList = menuDao.queryList(queryParam);
        if(StringUtil.objIsNotEmpty(childrenList)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_CHILDREN_IS_NOT_NULL);
        }
        return menuDao.deleteById(id);
    }

    @Override
    public TblMenu queryMenuById(String id) throws AppException {
        TblMenu menu = menuDao.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(menu)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_INFO_IS_NULL);
        }
        return menu;
    }

    @Override
    public PageResult queryParentMenu(PageRequest pageQuery) {
        PageInfo<TblMenu> pageInfo = this.queryPageParentMenu(pageQuery);
        return PageUtils.getPageResult(pageInfo);
    }

    @Override
    public int updateByPrimaryKeySelective(TblMenuDto record) throws AppException {
        String id = record.getId();
        TblMenu menu = menuDao.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(menu)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_INFO_IS_NULL);
        }
        BeanUtils.copyProperties(record, menu);
        TblUser loginUser = commonService.getLoginUser();
        String loginUserId = loginUser.getId();
        menu.setUpdateUser(loginUserId);
        return menuDao.updateByPrimaryKeySelective(menu);
    }

    /**
     * 根据父节点ID查出子节点
     * @param parentId 父节点ID
     * @param allTree 所有节点
     * @return
     */
    private List<TblMenu> getChildren(String parentId, List<TblMenu> allTree){
        List<TblMenu> childrenTree = new ArrayList<>();
        for(TblMenu item : allTree){
            if(parentId.equals(item.getParentNode())){
                childrenTree.add(item);
                continue;
            }
        }
        for (TblMenu item : childrenTree){
            item.setChildrenList(getChildren(item.getId(), allTree));
        }
        return childrenTree;
    }

    /**
     * 将菜单树形化
     *
     * @return
     */
    private List<TblMenu> treeMenu(TblMenu params) {
        List<TblMenu> rootTree = new ArrayList<>();
        List<TblMenu> allMenuList = menuDao.queryList(params);
        // 获取根菜单
        for (TblMenu item : allMenuList) {
            String parentNode = item.getParentNode();
            if (CommConstant.MENU_PRENT_NODE.equals(parentNode)) {
                rootTree.add(item);
                continue;
            }
        }
        // 查根菜单的子菜单
        for (TblMenu item : rootTree) {
            String id = item.getId();
            List<TblMenu> childrenTree = this.getChildren(id, allMenuList);
            item.setChildrenList(childrenTree);
        }
        return rootTree;
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<TblMenu> getPageInfo(PageRequest pageRequest) {
        int currentPage = pageRequest.getCurrentPage();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageRequest.getParams());
        TblMenu params = jsonObject.toJavaObject(TblMenu.class);
        params.setParentNode(CommConstant.MENU_PRENT_NODE);
        List<TblMenu> menuList = menuDao.queryList(params);
        return new PageInfo<>(menuList);
    }

    /**
     * 根据父节点查出子节点
     *
     * @param parentTree 父节点
     * @return
     */
    private List<TblMenu> getChildren(List<TblMenu> parentTree) {
        for (TblMenu item : parentTree) {
            String id = item.getId();
            TblMenu params = new TblMenu();
            params.setParentNode(id);
            List<TblMenu> childrenTree = menuDao.queryList(params);
            if (childrenTree != null) {
                this.getChildren(childrenTree);
            }
            item.setChildrenList(childrenTree);
        }
        return parentTree;
    }

    /**
     * 分页查询所有父菜单
     * @param pageQuery
     * @return
     */
    private PageInfo<TblMenu> queryPageParentMenu(PageRequest pageQuery) {
        int currentPage = pageQuery.getCurrentPage();
        int pageSize = pageQuery.getPageSize();
        PageHelper.startPage(currentPage, pageSize);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageQuery.getParams());
        QueryParentMenuParamsDto params = jsonObject.toJavaObject(QueryParentMenuParamsDto.class);
        List<TblMenu> menuList = menuDao.queryPageParentMenu(params);
        return new PageInfo<>(menuList);
    }
}
