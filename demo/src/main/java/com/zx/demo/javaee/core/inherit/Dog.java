package com.zx.demo.javaee.core.inherit;

/**
 * Title: Dog
 * Description: Dog
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/7 17:43
 */
public class Dog extends BaseAnimal {

    @Override
    public void run() {
        System.out.println("Dog run");
    }
}
