package com.test.api.api.action;

import com.test.api.api.bean.TblRole;
import com.test.api.api.config.Result;
import com.test.api.api.dto.DeleteDataDto;
import com.test.api.api.dto.rolemanager.TblRoleDto;
import com.test.api.api.service.ITblRoleService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className RoleController
 * @description 角色控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:13 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "角色控制器")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private ITblRoleService roleService;

    /**
     * 用户列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "角色列表查询", notes = "角色列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = roleService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 添加角色
     *
     * @param roleDto
     * @return
     */
    @PostMapping(value = "/insertRole")
    @ApiImplicitParam(name = "roleDto", value = "新增角色的参数")
    @ApiOperation(value = "添加角色", notes = "添加角色")
    public Result insertRole(@RequestBody @Validated TblRoleDto roleDto) {
        TblRole role = new TblRole();
        BeanUtils.copyProperties(roleDto, role);
        int num = roleService.insertSelective(role);
        return ResultUtil.success(num);
    }

    /**
     * 通过主键查询角色
     * @param dto ID
     * @return
     */
    @ApiImplicitParam(name = "id", value = "角色主键")
    @ApiOperation(value = "通过ID查询角色信息", notes = "通过ID查询角色信息")
    @PostMapping(value = "/queryById")
    public Result queryById(@RequestBody @Validated DeleteDataDto dto) {
        TblRole Role = roleService.selectByPrimaryKey(dto.getId());
        return ResultUtil.success(Role);
    }

    /**
     * 修改角色
     *
     * @param roleDto
     * @return
     */
    @PostMapping(value = "/updateRole")
    @ApiImplicitParam(name = "roleDto", value = "修改角色的参数")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    public Result updateRole(@RequestBody @Validated TblRoleDto roleDto) {
        TblRole role = new TblRole();
        BeanUtils.copyProperties(roleDto, role);
        int num = roleService.updateByPrimaryKeySelective(role);
        return ResultUtil.success(num);
    }

    /**
     * 逻辑删除角色
     *
     * @param roleDto
     * @return
     */
    @PostMapping(value = "/updateRoleDelTag")
    @ApiImplicitParam(name = "roleDto", value = "逻辑删除角色的参数")
    @ApiOperation(value = "逻辑删除角色", notes = "逻辑删除角色")
    public Result updateRoleDelTag(@RequestBody @Validated DeleteDataDto roleDto) {
        TblRole role = new TblRole();
        BeanUtils.copyProperties(roleDto, role);
        int num = roleService.updateRoleDelTag(role);
        return ResultUtil.success(num);
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @GetMapping(value = "/queryAllRole")
    @ApiOperation(value = "查询所有角色", notes = "查询所有角色")
    public Result queryAllRole() {
        List<TblRole> roleList = roleService.queryAllRole();
        return ResultUtil.success(roleList);
    }
}
