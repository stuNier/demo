package com.zx.demo.config;

import com.zx.demo.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Title: LoginConfig
 * Description: 登录拦截器配置
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 16:07
 */
//@Configuration
public class LoginConfig implements WebMvcConfigurer{

    private final LoginHandlerInterceptor loginHandlerInterceptor;

    @Autowired
    public LoginConfig(LoginHandlerInterceptor loginHandlerInterceptor) {
        this.loginHandlerInterceptor = loginHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(loginHandlerInterceptor);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(                         //添加不拦截路径
                "/**/login",
                "/**/*.js",
                "/**/*.css",
                "/**/*.woff",
                "/**/*.ttf"
        );
    }

}
