package com.test.api.api.action;

import com.test.api.api.bean.TblSpecificationGroup;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.specificationgroup.TblSpecificationGroupAddDto;
import com.test.api.api.dto.commodity.specificationgroup.TblSpecificationGroupUpdateDto;
import com.test.api.api.service.ITblSpecificationGroupService;
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
 * @className SpecificationGroupController
 * @description 产品规格分组控制器
 * @auther wangsheng
 * @creatTime 2021/12/30 上午12:45
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("/specificationGroup")
@Api(value = "产品规格分组控制器")
public class SpecificationGroupController {

    @Autowired
    private ITblSpecificationGroupService specificationGroupService;

    /**
     * 产品规格分组列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "产品规格分组列表查询", notes = "产品规格分组列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = specificationGroupService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 添加产品规格分组
     *
     * @param specificationGroupAddDto
     * @return
     */
    @PostMapping(value = "/insertSpecificationGroup")
    @ApiImplicitParam(name = "specificationGroupAddDto", value = "产品规格分组")
    @ApiOperation(value = "添加产品规格分组", notes = "添加产品规格分组")
    public Result insertSpecificationGroup(@RequestBody @Validated TblSpecificationGroupAddDto specificationGroupAddDto) {
        TblSpecificationGroup specificationGroup = new TblSpecificationGroup();
        BeanUtils.copyProperties(specificationGroupAddDto, specificationGroup);
        int num = specificationGroupService.insertSelective(specificationGroup);
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
        TblSpecificationGroup spuBrand = specificationGroupService.selectByPrimaryKey(ddDto.getId());
        return ResultUtil.success(spuBrand);
    }

    /**
     * 修改
     *
     * @param specificationGroupUpdateDto
     * @return
     */
    @PostMapping(value = "/updateSpecificationGroup")
    @ApiImplicitParam(name = "specificationGroupUpdateDto", value = "产品规格分组")
    @ApiOperation(value = "修改", notes = "修改")
    public Result updateSpecificationGroup(@RequestBody @Validated TblSpecificationGroupUpdateDto specificationGroupUpdateDto) {
        TblSpecificationGroup specificationGroup = new TblSpecificationGroup();
        BeanUtils.copyProperties(specificationGroupUpdateDto, specificationGroup);
        int num = specificationGroupService.updateByPrimaryKeySelective(specificationGroup);
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
        TblSpecificationGroup specificationGroup = new TblSpecificationGroup();
        specificationGroup.setId(ddDto.getId());
        int num = specificationGroupService.updateDelTag(specificationGroup);
        return ResultUtil.success(num);
    }

}
