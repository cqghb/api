package com.test.api.api.service;

import com.test.api.api.bean.TblMenu;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.MenuTree;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblMenuService
 * @description 菜单服务接口
 * @auther wangsheng
 * @creatTime 2020/11/7 7:51 下午
 * @company demo
 * @department demo
 */
public interface ITblMenuService {
    /**
     * 查询菜单树
     * @return
     */
    MenuTree queryMenu();

    /**
     * 菜单管理列表查询
     * @param pageQuery 查询条件
     * @return
     */
    PageResult queryMenuList(PageRequest pageQuery);

    /**
     * 新增菜单-空值不落表
     * @param menu
     * @return
     */
    int insertSelective(TblMenu menu);

    /**
     * 通过ID删除菜单
     * @param id 主键
     * @return
     */
    int deleteById(String id) throws AppException;
}
