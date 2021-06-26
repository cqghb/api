package com.test.api.api.myinterceptor;

import com.alibaba.fastjson.JSON;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @projectName api
 * @package com.test.api.api.myinterceptor
 * @className RedisSessionInterceptor
 * @description 拦截登录失效的请求
 * @auther wangsheng
 * @creatTime 2021/6/22 1:35 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class RedisSessionInterceptor implements HandlerInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(RedisSessionInterceptor.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));//支持跨域请求
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");//是否支持cookie跨域
//        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");//Origin, X-Requested-With, Content-Type, Accept,Access-Token

        //Origin, X-Requested-With, Content-Type, Accept,Access-Token

        logger.info("[登录拦截] 拦截请求检查用户登录信息是否过期");
        logger.info("[登录拦截] 请求地址:" + request.getRequestURI());
        // 无论访问的地址是不是正确的，都进行登录验证，登录成功后的访问再进行分发，404的访问自然会进入到错误控制器中
//        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String userKey = "";
        for(Cookie item : cookies){
            if(item.getName().equalsIgnoreCase(CommConstant.REDIS_USER_KEY)){
                userKey = item.getValue();
                break;
            }
        }
        if(redisTemplate.hasKey(userKey)){
            return true;
        }
//        TblUser userInfo = JsonUtils.jsonToPojo((String) redisTemplate.opsForValue().get(userKey), TblUser.class);
//        if(null != userInfo){
//            return true;
//        }
//        response.addCookie(new Cookie("JSESSIONID",session.getId()));
//        logger.info("[登录拦截] sessionId=:" + session.getId());
//        logger.info("[登录拦截] REDIS_USER_KEY=" + session.getAttribute(CommConstant.REDIS_USER_KEY));
//        if(session.getAttribute(CommConstant.REDIS_USER_KEY) != null){
//            TblUser userInfo = (TblUser)redisTemplate.opsForValue().get(CommConstant.REDIS_USER_KEY);
//            if(null != userInfo){
//                return true;
//            }
//        }
        this.response(response);
        return false;
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
