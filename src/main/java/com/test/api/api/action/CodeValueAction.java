package com.test.api.api.action;

import com.test.api.api.service.ITblCodeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className CodeValueAction
 * @description 码值控制器
 * @auther wangsheng
 * @creatTime 2021/5/10 12:34 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
public class CodeValueAction {

    @Autowired
    private ITblCodeValueService iTblCodeValueService;
}
