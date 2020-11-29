package com.test.api.api.action;

import com.test.api.api.bean.TblUser;
import com.test.api.api.config.Result;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className UserAction
 * @description 用户管理
 * @auther wangsheng
 * @creatTime 2020/11/6 12:36 上午
 * @company demo
 * @department demo
 */
@RestController
public class UserAction {
    @Autowired
    private ITblUserService userService;

    /**
     * 用户假登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public Result login(@RequestBody TblUser user){
        TblUser resUser = userService.login(user.getId(), user.getPass());
        return ResultUtil.success(resUser);
    }
//    @RequestMapping(value = "/queryList")
//    public TblUser queryList(@RequestBody TblUser user){
//        return userService.queryList(user);
//    }

    /**
     * 用户列表查询
     * @param pageQuery
     * @return
     */
    @PostMapping(value="/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = userService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping(value="/insertUser")
    public int insertUser(@RequestBody TblUser user) {
        return userService.insert(user);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping(value="/deleteUser")
    public int deleteUser(@RequestBody TblUser user) {
        String id = user.getId();
//        TODO 验证后续再加
//        if(!StringUtils.isEmpty(id)){
//
//        }
        return userService.deleteUser(id);
    }

    @PostMapping(value="/queryUserById")
    public Result queryUserById(@RequestBody TblUser user) {
        String id = user.getId();
//        TODO 验证后续再加
//        if(!StringUtils.isEmpty(id)){
//
//        }
        TblUser tblUser = userService.queryUserById(id);
        return ResultUtil.success(tblUser);
    }
}
