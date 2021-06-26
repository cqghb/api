package com.test.api.api.action;

import com.test.api.api.bean.TblUser;
import com.test.api.api.bo.UserBo;
import com.test.api.api.config.Result;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Api(value = "测试接口", tags = "用户管理相关的接口", description = "用户测试接口")
public class UserAction {

    protected static final Logger logger = LoggerFactory.getLogger(UserAction.class);

//    @Autowired
//    private HttpSession session;

    @Autowired
    private ITblUserService userService;

    /**
     * 用户假登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public Result login(@RequestBody TblUser user, HttpServletRequest request, HttpServletResponse response){
        String id = user.getId();
        String userKey = id + StringUtil.uuid();
        TblUser resUser = userService.login(id, user.getPass(),userKey);
        if(null != resUser){
//            HttpSession session = request.getSession();
//            logger.info("[登录] sessionID= " + session.getId());
//            session.setAttribute(CommConstant.REDIS_USER_KEY, userKey);

            Cookie cookie = new Cookie(CommConstant.REDIS_USER_KEY, userKey);
            response.addCookie(cookie);
        }
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
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
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
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result insertUser(@RequestBody UserBo user) {
        String userId = userService.insert(user);
        return ResultUtil.success(userId);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping(value="/registerUser")
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result registerUser(@RequestBody UserBo user) {
        String userId = userService.insert(user);
        return ResultUtil.success(userId);
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

    /**
     * 重置密码
     * @param user
     * @return
     */
    @PostMapping(value="/resetPass")
    public Result resetPass(@RequestBody UserBo user) {
        int num = userService.resetPass(user);
        return ResultUtil.success(num);
    }
}
