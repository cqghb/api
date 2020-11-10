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
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
public class UserAction {
    @Autowired
    private ITblUserService userService;

    @RequestMapping(value = "/login")
    public TblUser login(@RequestBody TblUser user){
        return userService.login(user.getId(), user.getPass());
    }
}
