package com.test.api.api.action;

import com.test.api.api.bean.TblSpu;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonCodeDto;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.spu.AddSpuDto;
import com.test.api.api.dto.commodity.spu.UpdateSpuDto;
import com.test.api.api.service.ITblSpuService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.commodity.spu.ListSpuVO;
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
 * @className SpuController
 * @description 货品控制器
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:38
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("/spu")
@Api(value = "货品控制器")
public class SpuController {

    protected static final Logger logger = LoggerFactory.getLogger(SpuController.class);

    @Autowired
    private ITblSpuService spuService;


    /**
     * 货品列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "货品列表查询", notes = "货品列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = spuService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 通过主键查询
     * @param ddDto
     * @return
     */
    @ApiImplicitParam(name = "id", value = "货品主键")
    @ApiOperation(value = "通过ID查询数据操作信息", notes = "通过ID查询数据操作信息")
    @PostMapping(value = "/queryById")
    public Result queryById(@RequestBody @Validated CommonIdDto ddDto) {
        ListSpuVO spuType = spuService.selectDetail(ddDto.getId());
        return ResultUtil.success(spuType);
    }

    /**
     * 通过编码查询
     * @param codeDto 货品编码
     * @return
     */
    @ApiImplicitParam(name = "codeDto", value = "货品编码")
    @ApiOperation(value = "通过ID查询数据操作信息", notes = "通过ID查询数据操作信息")
    @PostMapping(value = "/queryByCode")
    public Result queryByCode(@RequestBody @Validated CommonCodeDto codeDto) {
        TblSpu spuType = spuService.queryByCode(codeDto.getCode());
        return ResultUtil.success(spuType);
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
        TblSpu spu = new TblSpu();
        spu.setId(ddDto.getId());
        int num = spuService.updateDelTag(spu);
        return ResultUtil.success(num);
    }

    /**
     * 修改
     *
     * @param addSpu 货品信息
     * @return
     */
    @PostMapping(value = "/addSpu")
    @ApiImplicitParam(name = "addSpu", value = "添加货品的参数")
    @ApiOperation(value = "添加货品类型", notes = "添加货品类型")
    public Result addSpu(@RequestBody @Validated AddSpuDto addSpu) {
        TblSpu spu = new TblSpu();
        BeanUtils.copyProperties(addSpu, spu);
        int num = spuService.insertSelective(spu);
        return ResultUtil.success(num);
    }

    /**
     * 修改
     *
     * @param update
     * @return
     */
    @PostMapping(value = "/updateSpu")
    @ApiImplicitParam(name = "update", value = "维护货品的参数")
    @ApiOperation(value = "修改货品信息", notes = "修改货品信息")
    public Result updateSpu(@RequestBody @Validated UpdateSpuDto update) {
        TblSpu spu = new TblSpu();
        BeanUtils.copyProperties(update, spu);
        int num = spuService.updateByPrimaryKeySelective(spu);
        return ResultUtil.success(num);
    }

    /**
     * 查询SPU的ID和名称[前端下拉选项]
     * @param ddDto 查询条件
     * @return
     */
    @PostMapping(value="/searchSpuCodeName")
    public Result searchSpuCodeName(@RequestBody AddSpuDto ddDto) {
        logger.info("[查询SPU的ID和名称] action start: codeType=" + ddDto.getCode());
        List<Map<String, String>> codeKeyValueList = spuService.searchSpuCodeName(ddDto.getCode());
        logger.info("[查询SPU的ID和名称] action end");

        return ResultUtil.success(codeKeyValueList);
    }

}
