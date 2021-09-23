package com.test.api.api.action;


import com.test.api.api.bean.TblMenu;
import com.test.api.api.config.Result;
import com.test.api.api.dto.menumanager.QueryMenuParamDto;
import com.test.api.api.service.ITblMenuService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.MenuTree;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className MenuAction
 * @description 菜单管理控制器
 * @auther wangsheng
 * @creatTime 2020/11/8 8:31 下午
 * @company demo
 * @department demo
 */
@RestController
@Api(value = "菜单管理")
@RequestMapping("/menu")
public class MenuAction {

    @Autowired
    private ITblMenuService menuService;

    @ApiOperation(value = "后台管理主页面菜单树查询", notes = "主页面左侧菜单")
    @RequestMapping(value = "/queryMenu")
    public Result queryMenu(){
        MenuTree menuTree = menuService.queryMenu();
        return ResultUtil.success(menuTree);
    }

    /**
     * 菜单管理页面菜单列表查询
     *
     * @param pageQuery 查询条件
     * @return
     */
    @ApiOperation(value = "菜单列表查询", notes = "菜单管理页面表格数据")
    @RequestMapping(value = "/queryMenuList")
    public Result queryMenuList(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = menuService.queryMenuList(pageQuery);
        return ResultUtil.success(pageResult);
    }

    @PostMapping(value="/insertMenu")
    @ApiImplicitParam(name = "menu", value = "新增菜单的参数")
    @ApiOperation(value = "添加菜单", notes = "添加菜单")
    public Result insertMenu(@RequestBody @Validated TblMenu menu) {
        int num = menuService.insertSelective(menu);
        return ResultUtil.success(num);
    }
    @ApiImplicitParam(name = "dto", value = "删除菜单的参数")
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @PostMapping(value="/deleteMenu")
    public Result deleteMenu(@RequestBody @Validated QueryMenuParamDto dto) {
        int num = menuService.deleteById(dto.getId());
        return ResultUtil.success(num);
    }

    @ApiImplicitParam(name = "dto", value = "查询菜单的参数")
    @ApiOperation(value = "通过ID查询菜单", notes = "通过ID查询菜单")
    @PostMapping(value="/queryMenuById")
    public Result queryMenuById(@RequestBody @Validated QueryMenuParamDto dto) {
        TblMenu menu = menuService.queryMenuById(dto.getId());
        return ResultUtil.success(menu);
    }

    @ApiImplicitParam(name = "dto", value = "分页查询所有父菜单的参数")
    @ApiOperation(value = "分页查询所有父菜单", notes = "分页查询所有父菜单")
    @PostMapping(value="/queryParentMenu")
    public Result queryParentMenu(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = menuService.queryParentMenu(pageQuery);
        return ResultUtil.success(pageResult);
    }
}
