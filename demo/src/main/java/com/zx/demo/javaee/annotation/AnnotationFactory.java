package com.zx.demo.javaee.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * Title: AnnotationFactory
 * Description: 注解解析工厂
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:14
 */
@Slf4j
public class AnnotationFactory
{
    public static User create()
    {
        User user = new User();
        // 获取User类中所有的方法（getDeclaredMethods也行）
        Field[] fields = User.class.getDeclaredFields();
        try
        {
            for (Field field : fields)
            {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (field.isAnnotationPresent(Init.class))
                {
                    Init init = field.getAnnotation(Init.class);
                    user.setName(init.value());
                }
            }
        }
        catch (Exception e)
        {
            log.error("{}",e);
            return null;
        }
        return user;
    }
}
