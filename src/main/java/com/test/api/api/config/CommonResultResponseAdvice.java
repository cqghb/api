package com.test.api.api.config;

import com.test.api.api.vo.CommonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className CommonResultResponseAdvice
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/9 12:27 上午
 * @company demo
 * @department demo
 */
@Configuration
@EnableWebMvc
@RestControllerAdvice("com.test.api.api.action")
public class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof CommonResult) {
            return body;
        }
        return new CommonResult<>(body);
    }
}
