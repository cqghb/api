package com.test.api.api.utils;

import com.test.api.api.config.Result;
import com.test.api.api.constant.MsgCodeConstant;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className ResultUtil
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/29 4:20 下午
 * @company demo
 * @department demo
 */
public class ResultUtil {

    /**
     * 成功响应并返回业务数据
     * @param object 响应业务数据
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(MsgCodeConstant.SUCESS_CODE);
        result.setMsg(MsgCodeConstant.SUCESS_MSG);
        result.setData(object);
        return result;
    }

    /**
     * 默认成功响应
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 异常时响应对象
     * @param code 消息码
     * @param msg 响应消息
     * @return
     */
    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result error(String[] msg) {
        Result result = new Result();
        result.setCode(msg[0]);
        result.setMsg(msg[1]);
        return result;
    }
    /**
     * 异常时响应对象，返回默认消息
     * @return
     */
    public static Result error() {
        Result result = new Result();
        result.setCode(MsgCodeConstant.ERROR_CODE);
        result.setMsg(MsgCodeConstant.ERROR_MSG);
        return result;
    }
}
