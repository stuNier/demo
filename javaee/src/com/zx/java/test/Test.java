package com.zx.java.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * Title: Test
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2019/12/10 17:31
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        Test test = new Test();
        LinkedList<String> colors = new LinkedList<>();
        colors.add("red");
        colors.add("blue");
        test.func(ClassPath.COLOR, "getColor", String.class);

    }


    public <T> void func(String classPath, String methodName, Class<T>...rgs){
        try {

            LinkedList<String> colors = new LinkedList<>();
            colors.add("red");
            colors.add("blue");
            Class<?> object = Class.forName(classPath);
            Method method = object.getMethod(methodName);
            method.invoke(object.newInstance(), colors);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            logger.error("错误信息{}", e.getMessage());
        }
    }


}
