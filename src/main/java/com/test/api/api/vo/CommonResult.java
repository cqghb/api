package com.test.api.api.vo;

import lombok.Data;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className CommonResult
 * @description 视图基础对象
 * @auther wangsheng
 * @creatTime 2020/11/9 12:21 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class CommonResult<T> {
    // 状态码
    private int status = 1;
    // 异常代码
    private String errorCode = "";
    // 异常消息
    private String errorMsg = "";

    private T resultBody;

    public CommonResult() {
    }
    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }

    public CommonResult(int status, String errorCode, String errorMsg, T resultBody) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.resultBody = resultBody;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public T getResultBody() {
        return resultBody;
    }

    public void setResultBody(T resultBody) {
        this.resultBody = resultBody;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "status=" + status +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", resultBody=" + resultBody +
                '}';
    }
}
