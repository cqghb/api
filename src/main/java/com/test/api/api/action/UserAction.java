package com.test.api.api.action;

import com.test.api.api.bean.TblUser;
import com.test.api.api.service.ITblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className UserAction
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/6 12:36 上午
 * @company demo
 * @department demo
 */
@RestController
public class UserAction {
    @Autowired
    private ITblUserService userService;

    @RequestMapping(value = "/login")
    public TblUser login(@RequestBody TblUser user){
        return userService.login(user.getId(), user.getPass());
    }
//    @RequestMapping(value = "/queryList")
//    public TblUser queryList(@RequestBody TblUser user){
//        return userService.queryList(user);
//    }
}
