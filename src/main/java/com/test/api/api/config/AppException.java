package com.test.api.api.config;

import com.alibaba.fastjson.JSON;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className AppException
 * @description 自定义异常类
 * @auther wangsheng
 * @creatTime 2020/11/29 5:12 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class AppException extends RuntimeException {
    // 错误码
    private String errorCode;
    // 错误消息
    private String errorMsg;

    public AppException() {
    }

    public AppException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "AppException{" + JSON.toJSONString(this) + "}";
    }
}
