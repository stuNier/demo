package com.zx.demo.javaee.core.inherit;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: Children
 * Description: 子类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/7 17:16
 */
@Slf4j
public class Children extends Parent{

    static {
        log.info("Children的static代码块");
    }

    {
        log.info("Children代码块");
    }

    /**
     * 构造函数
     */
    public Children(){
        log.info("Children无参构造");
    }

    /**
     * 构造函数
     *
     * @param name name
     */
    public Children(String name) {
        super(name);
        log.info("Children有参构造");
    }
}
