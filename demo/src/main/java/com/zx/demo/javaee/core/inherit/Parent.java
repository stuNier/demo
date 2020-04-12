package com.zx.demo.javaee.core.inherit;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: Parent
 * Description: 父类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/7 17:15
 */
@Slf4j
public class Parent {
    /**
     * name
     */
    private String name;

    static {
        log.info("Parent的static代码块");
    }

    {
        log.info("Parent代码块");
    }
    /**
     * 构造函数
     */
    public Parent(){
        log.info("Parent无参构造");
    }

    /**
     * 构造函数
     * @param name name
     */
    public Parent(String name){
        this.name = name;
        log.info("Parent有参构造");
    }
}
