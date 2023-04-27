package com.test.api.api.vo;

import lombok.Data;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className CommonResult
 * @description 视图基础对象
 * @auther wangsheng
 * @creatTime 2020/11/9 12:21 上午
 * @company demo
 * @department demo
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
}
