package com.test.api.api.config;

import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
@RestControllerAdvice
public class ExceptionHandle {

    protected static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Result customException(Exception e){
        logger.info("已进入Exception异常处理逻辑");
        return ResultUtil.error(MsgCodeConstant.ERROR_CODE, e.getMessage());
    }
    @ExceptionHandler(value = AppException.class)
    public Result customException2(AppException appException){
        logger.info("已进入AppException异常处理逻辑");
        return ResultUtil.error(appException.getErrorCode(), appException.getErrorMsg());
    }
}
