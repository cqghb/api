package com.test.api.api.action;

import com.test.api.api.bean.TblSku;
import com.test.api.api.config.Result;
import com.test.api.api.dto.CommonIdDto;
import com.test.api.api.dto.commodity.sku.AddSkuDto;
import com.test.api.api.service.ITblSkuService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className SkuController
 * @description 产品控制器
 * @auther wangsheng
 * @creatTime 2021/12/19 下午6:11
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("/sku")
@Api(value = "产品控制器")
public class SkuController {

    protected static final Logger logger = LoggerFactory.getLogger(SkuController.class);

    @Autowired
    private ITblSkuService skuService;

    /**
     * 产品列表查询
     *
     * @param pageQuery
     * @return
     */
    @ApiOperation(value = "产品列表查询", notes = "产品列表查询")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = skuService.findPage(pageQuery);
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
        TblSku sku = skuService.selectByPrimaryKey(ddDto.getId());
        return ResultUtil.success(sku);
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
        TblSku sku = new TblSku();
        sku.setId(ddDto.getId());
        int num = skuService.updateDelTag(sku);
        return ResultUtil.success(num);
    }

    /**
     * 添加产品
     * @param addSkuDto
     * @return
     */
    @PostMapping(value = "/addSku")
    @ApiImplicitParam(name = "addSkuDto", value = "逻辑删除的数据操参数")
    @ApiOperation(value = "添加产品", notes = "添加产品")
    public Result addSku(@RequestBody @Validated AddSkuDto addSkuDto) {
        boolean r = skuService.addSku(addSkuDto);
        return ResultUtil.success(r);
    }

}
