package com.test.api.api.config;

import com.alibaba.fastjson.JSON;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className Result
 * @description 公共响应对象
 * @auther wangsheng
 * @creatTime 2020/11/29 4:16 下午
 * @company demo
 * @department demo
 */
public class Result<T> {
    /** 错误码 */
    private String code;

    /** 提示信息 */
    private String msg;

    /** 具体的内容 */
    private T data;

    public Result() {
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return " Result {" + JSON.toJSONString(this) + '}';
    }
}
