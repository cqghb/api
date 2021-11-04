package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.dto.rolemenurelation.RoleMenuRelationSettingDto;
import com.test.api.api.service.ITblRoleMenuRelationService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.rolemenurelation.RoleMenuRelationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className RoleMenuRelationController
 * @description 角色菜单关系控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:13 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "角色菜单关系控制器")
@RequestMapping("/roleMenuRelation")
public class RoleMenuRelationController {

    @Autowired
    protected ITblRoleMenuRelationService roleMenuRelationService;

    /**
     * 维护角色菜单权限
     * @param dto
     * @return
     */
    @PostMapping(value = "/updateRoleMenuRelation")
    @ApiImplicitParam(name = "dto", value = "修改操作的参数")
    @ApiOperation(value = "修改操作", notes = "修改操作")
    public Result updateRoleMenuRelation(@RequestBody @Validated RoleMenuRelationSettingDto dto) {
        int num = roleMenuRelationService.updateRoleMenuRelation(dto);
        return ResultUtil.success(num);
    }

    @GetMapping(value="/queryRoleMenu")
    @ApiImplicitParam(name = "roleId", value = "角色主键")
    @ApiOperation(value = "根据角色主键查询所有角色菜单", notes = "根据角色主键查询所有角色菜单")
    public Result queryRoleMenu(@RequestParam("roleId") String roleId) {
        List<RoleMenuRelationVO> verCode = roleMenuRelationService.queryRoleMenu(roleId);
        return ResultUtil.success(verCode);
    }
}
