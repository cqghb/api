package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.service.ITblRoleService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "角色列表查询", notes = "角色列表查询")
    @PostMapping(value="/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = roleService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

}
