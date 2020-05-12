package com.zx.demo.javaee.pattern.single;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Title: SingletonTest
 * Description: 单例模式测试类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:32
 */
@Slf4j
public class SingletonTest {

    @Test
    public void test(){
        Singleton a = Singleton.getSingleton();
        Singleton b = Singleton.getSingleton();
        log.info(Boolean.toString(a.equals(b)));
        log.info("a:"+a+";b:"+b);
    }
}
