package com.test.api.api.action;

import com.test.api.api.service.ITblCodeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className CodeTypeAction
 * @description 码值类型控制器
 * @auther wangsheng
 * @creatTime 2021/5/10 12:33 上午
 * @company
 * @department 
 */
@RestController
public class CodeTypeAction {

    @Autowired
    private ITblCodeTypeService iTblCodeTypeService;
}
