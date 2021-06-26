package com.test.api.api.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className SessionUtils
 * @description session 获取工具
 * @auther wangsheng
 * @creatTime 2021/6/22 1:26 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class SessionUtils {

    public static HttpSession getHttpSession(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(null != requestAttributes){
            HttpServletRequest request = requestAttributes.getRequest();
            HttpSession session = request.getSession();
            return session;
        }
        return null;
    }
}
