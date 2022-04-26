package com.test.api.api.action;

import com.test.api.api.bean.TblSpuType;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.sputype.AddTblSpuTypeDto;
import com.test.api.api.dto.commodity.sputype.UpdateTblSpuTypeDto;
import com.test.api.api.service.ITblSpuTypeService;
import com.test.api.api.utils.ResultUtil;
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

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className SpuTypeController
 * @description 货品类型控制器
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:42
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("/spuType")
@Api(value = "货品类型控制器")
public class SpuTypeController {

    protected static final Logger logger = LoggerFactory.getLogger(SpuTypeController.class);

    @Autowired
    private ITblSpuTypeService spuTypeService;

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "数据操作列表查询", notes = "数据操作列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = spuTypeService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }
    /**
     * 添加货品类型
     *
     * @param add
     * @return
     */
    @PostMapping(value = "/insertSpuType")
    @ApiImplicitParam(name = "add", value = "添加货品类型的参数")
    @ApiOperation(value = "添加货品类型", notes = "添加货品类型")
    public Result insertSpuType(@RequestBody @Validated AddTblSpuTypeDto add) {
        TblSpuType spuType = new TblSpuType();
        BeanUtils.copyProperties(add, spuType);
        int num = spuTypeService.insertSelective(spuType);
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
        TblSpuType spuType = spuTypeService.selectByPrimaryKey(ddDto.getId());
        return ResultUtil.success(spuType);
    }

    /**
     * 修改
     *
     * @param update
     * @return
     */
    @PostMapping(value = "/updateSpuType")
    @ApiImplicitParam(name = "update", value = "维护货品类型的参数")
    @ApiOperation(value = "修改货品类型", notes = "修改货品类型")
    public Result updateSpuType(@RequestBody @Validated UpdateTblSpuTypeDto update) {
        TblSpuType spuType = new TblSpuType();
        BeanUtils.copyProperties(update, spuType);
        int num = spuTypeService.updateByPrimaryKeySelective(spuType);
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
        TblSpuType spuType = new TblSpuType();
        spuType.setId(ddDto.getId());
        int num = spuTypeService.updateDelTag(spuType);
        return ResultUtil.success(num);
    }

    /**
     * 查询货品类型 id 、 name
     * @param spuType 查询条件
     * @return
     */
    @PostMapping(value="/searchSPUTypeCode")
    public Result searchSPUTypeCode(@RequestBody TblSpuType spuType) {
        List<Map<String, String>> codeKeyValueList = spuTypeService.searchSPUTypeCode(spuType);
        return ResultUtil.success(codeKeyValueList);
    }
}
