package com.test.api.api.action;

import com.test.api.api.bean.TblSpuBrand;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.spubrand.AddSpuBrandDto;
import com.test.api.api.dto.commodity.spubrand.UpdateSpuBrandDto;
import com.test.api.api.service.ITblSpuBrandService;
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

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className SpuBrandController
 * @description 商品品牌控制器
 * @auther wangsheng
 * @creatTime 2021/12/14 上午12:58
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "商品品牌控制器")
@RequestMapping("/spuBrand")
public class SpuBrandController {

    @Autowired
    private ITblSpuBrandService spuBrandService;

    /**
     * 商品品牌列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "商品品牌列表查询", notes = "商品品牌列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = spuBrandService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
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
        TblSpuBrand spuBrand = spuBrandService.selectByPrimaryKey(ddDto.getId());
        return ResultUtil.success(spuBrand);
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
        TblSpuBrand spuBrand = new TblSpuBrand();
        spuBrand.setId(ddDto.getId());
        int num = spuBrandService.updateDelTag(spuBrand);
        return ResultUtil.success(num);
    }

    /**
     * 修改
     *
     * @param update
     * @return
     */
    @PostMapping(value = "/updateSpuBrand")
    @ApiImplicitParam(name = "updateSpuBrand", value = "修改SPU产品品牌信息的参数")
    @ApiOperation(value = "修改SPU产品品牌信息", notes = "修改SPU产品品牌信息")
    public Result updateSpuBrand(@RequestBody @Validated UpdateSpuBrandDto update) {
        TblSpuBrand spuBrand = new TblSpuBrand();
        BeanUtils.copyProperties(update, spuBrand);
        int num = spuBrandService.updateByPrimaryKeySelective(spuBrand);
        return ResultUtil.success(num);
    }

    /**
     * 修改ØØ
     *
     * @param update
     * @return
     */
    @PostMapping(value = "/addSpuBrand")
    @ApiImplicitParam(name = "addSpuBrand", value = "新增SPU产品品牌信息的参数")
    @ApiOperation(value = "新增SPU产品品牌信息", notes = "新增SPU牌信息")
    public Result addSpuBrand(@RequestBody @Validated AddSpuBrandDto update) {
        TblSpuBrand spuBrand = new TblSpuBrand();
        BeanUtils.copyProperties(update, spuBrand);
        int num = spuBrandService.insertSelective(spuBrand);
        return ResultUtil.success(num);
    }

    /**
     * 查询货品品牌 id 、 name
     * @param spuBrand 查询条件
     * @return
     */
    @PostMapping(value="/searchSpuBrand")
    public Result searchSpuBrand(@RequestBody TblSpuBrand spuBrand) {
        List<Map<String, String>> codeKeyValueList = spuBrandService.searchSpuBrand(spuBrand);
        return ResultUtil.success(codeKeyValueList);
    }
}
