package com.test.api.api.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className Demo
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/10/29 12:51 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
public class Demo {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
