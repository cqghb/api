package com.test.api.api.action;

import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.config.Result;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.rolemanager.TblDataOperateInsertDto;
import com.test.api.api.dto.rolemanager.TblDataOperateUpdateDto;
import com.test.api.api.service.ITblDataOperateService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className DataOperateController
 * @description 数据操作权限控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:12 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "数据操作权限控制器")
@RequestMapping("/dataOperate")
public class DataOperateController {

    @Autowired
    private ITblDataOperateService dataOperateService;

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "数据操作列表查询", notes = "数据操作列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = dataOperateService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 新增操作
     * @param doDto
     * @return
     */
    @PostMapping(value = "/insertDop")
    @ApiImplicitParam(name = "dopDto", value = "新增操作的参数")
    @ApiOperation(value = "添加操作", notes = "添加操作")
    public Result insertDop(@RequestBody @Validated TblDataOperateInsertDto doDto) {
        TblDataOperate dop = new TblDataOperate();
        BeanUtils.copyProperties(doDto, dop);
        int num = dataOperateService.insertSelective(dop);
        return ResultUtil.success(num);
    }

    /**
     * 通过主键查询
     * @param ddDto
     * @return
     */
    @ApiImplicitParam(name = "id", value = "角色主键")
    @ApiOperation(value = "通过ID查询数据操作信息", notes = "通过ID查询数据操作信息")
    @PostMapping(value = "/queryById")
    public Result queryById(@RequestBody @Validated CommonIdDto ddDto) {
        TblDataOperate dataOperate = dataOperateService.selectByPKDelTag(ddDto.getId(), DelTagEnum.DEL_TAG_2.getCode());
        return ResultUtil.success(dataOperate);
    }

    /**
     * 维护操作
     * @param doDto
     * @return
     */
    @PostMapping(value = "/updateDop")
    @ApiImplicitParam(name = "doDto", value = "修改操作的参数")
    @ApiOperation(value = "修改操作", notes = "修改操作")
    public Result updateDop(@RequestBody @Validated TblDataOperateUpdateDto doDto) {
        TblDataOperate dop = new TblDataOperate();
        BeanUtils.copyProperties(doDto, dop);
        int num = dataOperateService.updateByPrimaryKeySelective(dop);
        return ResultUtil.success(num);
    }

    /**
     * 逻辑删除操作
     * @param ddDto
     * @return
     */
    @PostMapping(value = "/updateDelTag")
    @ApiImplicitParam(name = "ddDto", value = "逻辑删除的数据操参数")
    @ApiOperation(value = "逻辑删除数据操", notes = "逻辑删除数据操")
    public Result updateDelTag(@RequestBody @Validated CommonIdDto ddDto) {
        TblDataOperate dop = new TblDataOperate();
        BeanUtils.copyProperties(ddDto, dop);
        int num = dataOperateService.updateDelTag(dop);
        return ResultUtil.success(num);
    }
}
