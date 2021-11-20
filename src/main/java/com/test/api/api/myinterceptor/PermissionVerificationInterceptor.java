package com.test.api.api.myinterceptor;

import com.alibaba.fastjson.JSON;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.myinterceptor
 * @className PermissionVerificationInterceptor
 * @description 权限校验拦截器
 * @auther wangsheng
 * @creatTime 2021/11/20 11:05 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class PermissionVerificationInterceptor implements HandlerInterceptor {
    protected static final Logger logger = LoggerFactory.getLogger(PermissionVerificationInterceptor.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 在HandlerMapping确定适当的处理程序对象之后，但在HandlerAdapter调用处理程序之前调用。
     * DispatcherServlet处理由任意数量的拦截器组成的执行链中的处理程序，并将处理程序本身置于末尾。
     * 使用此方法，每个拦截器都可以决定中止执行链，通常发送HTTP错误或编写自定义响应。
     * 异步请求处理需要特殊注意事项.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[权限校验] 校验用户权限 start......");
        String uri = request.getRequestURI();/*/server/menu/queryMenuList*/
        String operName = uri.substring(7);
        // 处理白名单
        if(CommConstant.WHITE_LIST.contains(operName)){
            return true;
        }
        HttpSession session = request.getSession();
        String redisUserDataOperKey = (String) session.getAttribute(CommConstant.REDIS_USER_DATA_OPER_KEY);
        List<String> dataOperList = (List<String>) redisTemplate.opsForList().index(redisUserDataOperKey, 0);
        boolean going = dataOperList.contains(operName);
        if (going) {
            return true;
        }
        this.response(response);
        logger.info("[权限校验] 校验用户权限 end......");
        return false;
    }

    /**
     * 拦截处理程序的执行。在HandlerAdapter实际调用处理程序之后调用，但在DispatcherServlet呈现视图之前调用。
     * 可以通过给定的ModelAndView向视图公开其他模型对象。
     * DispatcherServlet处理执行链中的处理程序，该执行链由任意数量的拦截器组成，处理程序本身位于末尾。
     * 通过这种方法，每个拦截器都可以对执行进行后处理，以执行链的相反顺序应用。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求处理完成后（即呈现视图后）回调。将在处理程序执行的任何结果上调用，从而允许适当的资源清理。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void response(HttpServletResponse response) {
        response.setCharacterEncoding(CommConstant.ENCODED_UTF8);
        response.setContentType(CommConstant.CONTENT_TYPE_JSON);
        try {
            response.getWriter().print(JSON.toJSONString(new ResultUtil().error(MsgCodeConstant.USER_NOT_PERMISSION[0],
                    MsgCodeConstant.USER_NOT_PERMISSION[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
