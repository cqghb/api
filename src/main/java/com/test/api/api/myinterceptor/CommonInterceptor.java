package com.test.api.api.myinterceptor;

import com.alibaba.fastjson.JSON;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @projectName api
 * @package com.test.api.api.myinterceptor
 * @className RedisSessionInterceptor
 * @description 拦截所有请求
 * @auther wangsheng
 * @creatTime 2021/6/22 1:35 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("[公共拦截器] 拦截所有请求 start......");
        HttpSession session = request.getSession();
        response.addCookie(new Cookie(CommConstant.JSESSIONID,session.getId()));
        logger.info("[公共拦截器] sessionId=:" + session.getId());
        logger.info("[公共拦截器] 拦截所有请求 end......");
        return true;
    }

    private void response(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().print(JSON.toJSONString(new ResultUtil().error(MsgCodeConstant.LOING_INFO_INVALID[0],
                    MsgCodeConstant.LOING_INFO_INVALID[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
