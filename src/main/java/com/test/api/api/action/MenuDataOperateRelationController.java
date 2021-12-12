package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.menudataoperaterelationmanager.MenuDataOperateRelationSettingDto;
import com.test.api.api.service.ITblMenuDataOperateRelationService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.CodeValueVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className MenuDataOperateRelationController
 * @description 菜单数据操作权限关系控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:12 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "菜单数据操作权限关系控制器")
@RequestMapping("/menuDataOperateRelation")
public class MenuDataOperateRelationController {

    @Autowired
    private ITblMenuDataOperateRelationService menuDataOperateRelationService;

    /**
     * 维护操作
     * @param dto
     * @return
     */
    @PostMapping(value = "/updateMenuDataOperateRelation")
    @ApiImplicitParam(name = "dto", value = "修改操作的参数")
    @ApiOperation(value = "修改操作", notes = "修改操作")
    public Result updateMenuDataOperateRelation(@RequestBody @Validated MenuDataOperateRelationSettingDto dto) {
        int num = menuDataOperateRelationService.updateMenuDataOperateRelation(dto);
        return ResultUtil.success(num);
    }

    /**
     * 根据菜单ID查询出所有数据操作权限
     * @param dto 菜单ID
     * @return
     */
    @ApiOperation(value = "根据菜单ID查询出所有数据操作权限", notes = "根据菜单ID查询出所有数据操作权限")
    @PostMapping(value = "/queryMenuDataOperation")
    public Result queryMenuDataOperation(@RequestBody CommonIdDto dto) {
        List<CodeValueVO> dataOperationList = menuDataOperateRelationService.queryMenuDataOperation(dto.getId());
        return ResultUtil.success(dataOperationList);
    }
}
