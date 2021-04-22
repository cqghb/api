package com.test.api.api.action;

import com.test.api.api.bean.TblUser;
import com.test.api.api.config.Result;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        TblUser resUser = userService.login(user.getName(), user.getPass());
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
    public Result insertUser(@RequestBody TblUser user) {
        int num = userService.insert(user);
        return ResultUtil.success(num);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping(value="/deleteUser")
    public Result deleteUser(@RequestBody TblUser user) {
        String id = user.getId();
//        TODO 验证后续再加
//        if(!StringUtils.isEmpty(id)){
//
//        }
        int num = userService.deleteUser(id);
        return ResultUtil.success(num);
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

    @PostMapping(value="/updateUser")
    public Result updateUser(@RequestBody TblUser user) {
//        TODO 参数验证后续再加
//        if(!StringUtils.isEmpty(id)){
//
//        }
        int num = userService.update(user);
        return ResultUtil.success(num);
    }

    /**
     * 测试流式查询
     * @return
     */
    @PostMapping(value="/test")
    @Transactional
    public Result test() {
        List<TblUser> d = new ArrayList<>();
        try {
            try (Cursor<TblUser> list = userService.test()){
                list.forEach(item ->{
                    d.add(item);
                    System.out.println(item.toString());
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultUtil.success(d);
    }


}
