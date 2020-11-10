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
 * @company demo
 * @department demo
 */
@RestController
public class Demo {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
