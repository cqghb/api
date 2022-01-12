package com.test.api.api.action;

import com.test.api.api.bean.TblProperty;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.property.AddTblPropertyDto;
import com.test.api.api.dto.commodity.property.UpdateTblPropertyDto;
import com.test.api.api.service.ITblPropertyService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.commodity.property.PropertyVo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @className PropertyController
 * @description 产品属性控制器
 * @auther wangsheng
 * @creatTime 2021/12/20 上午1:06
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("/property")
@Api(value = "产品属性控制器")
public class PropertyController {

    protected static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    ITblPropertyService propertyService;

    /**
     * 产品属性列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "产品属性列表查询", notes = "产品属性列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = propertyService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 添加产品属性
     *
     * @param add
     * @return
     */
    @PostMapping(value = "/insertProperty")
    @ApiImplicitParam(name = "add", value = "添加货品类型的参数")
    @ApiOperation(value = "添加货品类型", notes = "添加货品类型")
    public Result insertProperty(@RequestBody @Validated AddTblPropertyDto add) {
        TblProperty property = new TblProperty();
        BeanUtils.copyProperties(add, property);
        int num = propertyService.insertSelective(property);
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
        TblProperty property = propertyService.selectByPrimaryKey(ddDto.getId());
        return ResultUtil.success(property);
    }

    /**
     * 通过产品属性主键ID查询详细信息
     * @param ddDto
     * @return
     */
    @ApiImplicitParam(name = "id", value = "产品属性主键")
    @ApiOperation(value = "通过产品属性主键ID查询详细信息", notes = "通过产品属性主键ID查询详细信息")
    @PostMapping(value = "/queryDetail")
    public Result queryDetail(@RequestBody @Validated CommonIdDto ddDto) {
        PropertyVo property = propertyService.queryDetail(ddDto.getId());
        return ResultUtil.success(property);
    }


    /**
     * 修改产品属性
     *
     * @param update
     * @return
     */
    @PostMapping(value = "/updateProperty")
    @ApiImplicitParam(name = "update", value = "维护货品类型的参数")
    @ApiOperation(value = "修改货品类型", notes = "修改货品类型")
    public Result updateProperty(@RequestBody @Validated UpdateTblPropertyDto update) {
        TblProperty property = new TblProperty();
        BeanUtils.copyProperties(update, property);
        int num = propertyService.updateByPrimaryKeySelective(property);
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
        TblProperty property = new TblProperty();
        property.setId(ddDto.getId());
        int num = propertyService.updateDelTag(property);
        return ResultUtil.success(num);
    }

}
