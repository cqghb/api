package com.test.api.api.config;

import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className ExceptionHandle
 * @description 捕获异常的类，返回信息给浏览器，可以自定义返回的code,msg等信息
 * @auther wangsheng
 * @creatTime 2020/11/29 5:05 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result customException(Exception e){
        if(e instanceof AppException){
            AppException appException = (AppException) e;
            return ResultUtil.error(appException.getErrorCode(), appException.getErrorMsg());
        } else {
            return ResultUtil.error(MsgCodeConstant.ERROR_CODE, e.getMessage());
        }
    }
}
