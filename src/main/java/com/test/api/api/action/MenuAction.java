package com.test.api.api.action;


import com.test.api.api.service.ITblMenuService;
import com.test.api.api.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className MenuAction
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/8 8:31 下午
 * @company demo
 * @department demo
 */
@RestController
public class MenuAction {

    @Autowired
    private ITblMenuService menuService;

    @RequestMapping(value = "/queryMenu")
    public MenuTree queryMenu(){
        return menuService.queryMenu();
    }
}
