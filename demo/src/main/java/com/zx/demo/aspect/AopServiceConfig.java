package com.zx.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Title: MyAspect
 * Description: AopServiceConfig
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/19 16:10
 */
@Slf4j
@Aspect
@Component
public class AopServiceConfig {

    @Pointcut("execution(* com.zx.demo.service.impl..*.*(..))")
    public void executeService() {}

    @Before("executeService()")
    public void before(JoinPoint joinPoint){
    }

    @After("executeService()")
    public void after(JoinPoint joinPoint){
    }


}
