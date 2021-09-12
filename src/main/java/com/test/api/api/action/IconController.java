package com.test.api.api.action;

import com.test.api.api.bean.TblIcon;
import com.test.api.api.config.Result;
import com.test.api.api.service.ITblIconService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className IconController
 * @description 图标管理
 * @auther wangsheng
 * @creatTime 2021/9/8 1:07 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController()
@RequestMapping("/icon")
@Api(value = "图标管理", tags = "图标管理相关的接口")
public class IconController {

    @Autowired
    private ITblIconService iconService;

    /**
     * 图标列表查询
     * @param pageQuery
     * @return
     */
    @PostMapping(value="/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = iconService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 查询所有图标
     * @return
     */
    @GetMapping(value="/queryAll")
    public Result queryAll() {
        List<TblIcon> pageResult = iconService.queryAll();
        return ResultUtil.success(pageResult);
    }

    @PostMapping(value="/insertIcon")
    @ApiImplicitParam(name = "icon", value = "新增的图标参数")
    @ApiOperation(value = "添加图标", notes = "添加图标")
    public Result insertUser(@RequestBody @Validated TblIcon icon) {
        int num = iconService.insertSelective(icon);
        return ResultUtil.success(num);
    }
}
