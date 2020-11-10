package com.test.api.api.service;

import com.test.api.api.bean.TblMenu;
import com.test.api.api.vo.MenuTree;

import java.util.List;

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
}
