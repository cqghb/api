package com.test.api.api.config;

import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

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
        logger.error(e.getMessage(), e);
        return ResultUtil.error(MsgCodeConstant.ERROR_CODE, e.getMessage());
    }
    @ExceptionHandler(value = AppException.class)
    public Result customException2(AppException appException){
        logger.info("已进入AppException异常处理逻辑");
        return ResultUtil.error(appException.getErrorCode(), appException.getErrorMsg());
    }
    // get
    @ExceptionHandler(value = BindException.class)
    public Result bindExceptionHandler(BindException e){
        logger.info("已进入BindException异常处理逻辑");
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultUtil.error(MsgCodeConstant.ERROR_CODE, message);
    }
    // post
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        logger.info("已进入BindException异常处理逻辑");
        StringBuilder errorMsg = new StringBuilder();

        for (int i = 0; i < e.getBindingResult().getAllErrors().size(); i++) {
            if (i > 0) {
                errorMsg.append(";");
            }
            ObjectError objectError = e.getBindingResult().getAllErrors().get(i);
            errorMsg.append(objectError.getDefaultMessage());
        }
        return ResultUtil.error(MsgCodeConstant.ERROR_CODE, errorMsg.toString());
    }
}
