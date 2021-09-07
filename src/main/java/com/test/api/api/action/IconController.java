package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.service.ITblIconService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
