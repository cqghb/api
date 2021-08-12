package com.test.api.api.action;

import com.test.api.api.bean.TblUser;
import com.test.api.api.bo.UserBo;
import com.test.api.api.config.AppException;
import com.test.api.api.config.Result;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.dto.usermanager.TblUserDto;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.ResultUtil;
import com.test.api.api.vo.UserVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result login(@RequestBody TblUser user){
        String id = user.getId();
        TblUser resUser = userService.login(id, user.getPass());
        if(null == resUser){
            return ResultUtil.error(MsgCodeConstant.USER_NOT_REGISTER);
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
    @PostMapping(value="/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        PageResult pageResult = userService.findPage(pageQuery);
        return ResultUtil.success(pageResult);
    }

    /**
     * 新增用户,登录之后新增用户，接口有验证
     * @param user
     * @return
     */
    @PostMapping(value="/insertUser")
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result insertUser(@RequestBody @Validated TblUserDto user) {
        UserBo user2 = new UserBo();
        BeanUtils.copyProperties(user, user2);
        String userId = userService.insert(user2);
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
        UserVO vo = userService.queryUserById(id);
//        if(vo.getLikes()==null){
//            vo.setLikes(new String[]{});
//        }
        return ResultUtil.success(vo);
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
     * 重置密码，没有登录的时候修改密码调用这个
     * @param user
     * @return
     */
    @PostMapping(value="/resetPass")
    public Result resetPass(@RequestBody UserBo user) {
        int num = userService.resetPass(user);
        return ResultUtil.success(num);
    }
    /**
     * 重置密码，登录之后修改密码调用这个
     * @param user
     * @return
     */
    @PostMapping(value="/resetPass2")
    public Result resetPass2(@RequestBody UserBo user) {
        int num = userService.resetPass(user);
        return ResultUtil.success(num);
    }

    /**
     * 退出登录
     * 清除Redis中保存的登录信息
     * @return
     */
    @PostMapping(value="/signOut")
    @ApiOperation(value = "退出登录", notes = "退出登录，删除Redis中的登录信息")
    public Result signOut() {
        userService.signOut();
        return ResultUtil.success();
    }

    /**
     * 自定义异常测试接口
     * @return
     */
    @PostMapping(value="/testAppException")
    @ApiOperation(value = "测试AppException是否起了作用", notes = "测试AppException是否起了作用,这个接口不开放给前端调用")
    public Result testAppException() {

        throw new AppException("123456","测试AppException");
    }
    /**
     * 自定义异常测试接口
     * @return
     */
    @PostMapping(value="/testException")
    @ApiOperation(value = "测试Exception是否起了作用", notes = "测试Exception是否起了作用,这个接口不开放给前端调用")
    public Result testException() {
        int a = 1/0;
        return ResultUtil.success();
    }
}
