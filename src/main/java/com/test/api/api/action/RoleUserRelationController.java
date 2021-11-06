package com.test.api.api.action;

import com.test.api.api.bean.TblRole;
import com.test.api.api.config.Result;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dto.usermanager.UserIdDto;
import com.test.api.api.service.ITblRoleUserRelationService;
import com.test.api.api.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className RoleUserRelationController
 * @description 角色用户关系控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:13 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "角色用户关系控制器")
@RequestMapping("/roleUserRelation")
public class RoleUserRelationController {

    @Autowired
    private ITblRoleUserRelationService roleUserRelationService;

    /**
     * 根据用户ID查询出所有角色权限
     *
     * @param dto 用户ID
     * @return
     */
    @ApiOperation(value = "根据用户ID查询出所有角色权限", notes = "根据用户ID查询出所有角色权限")
    @PostMapping(value = "/queryUserRoleByUserId")
    public Result queryUserRoleByUserId(@RequestBody UserIdDto dto) {
        List<TblRole> roleList = roleUserRelationService.queryUserRoleByUserId(dto.getId(), DelTagEnum.DEL_TAG_2.getCode());
        return ResultUtil.success(roleList);
    }
}
