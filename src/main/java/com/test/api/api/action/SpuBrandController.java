package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.service.ITblSpuBrandService;
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
}
