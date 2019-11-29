package com.zx.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: LoginHandlerInterceptor
 * Description: TODO 登录拦截
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 15:47
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    private final JedisPool jedisPool;

    private Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    @Autowired
    public LoginHandlerInterceptor(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；
     *         false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        Cookie[] cookies = request.getCookies();
        if(null==cookies){
            response.sendRedirect(request.getContextPath()+"/page/login?url="+request.getRequestURI());
            return false;
        }
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("userAccount")){
                String token = cookie.getValue();
                Jedis jedis = jedisPool.getResource();
                if(jedis.exists(token)){
                    jedis.close();
                    return true;
                }
                jedis.close();
            }
        }
        response.sendRedirect(request.getContextPath()+"/page/login?url="+request.getRequestURI());
        return false;
    }
    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("postHandle");
    }
    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finall
     * 但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        logger.info("afterCompletion");
    }

}
