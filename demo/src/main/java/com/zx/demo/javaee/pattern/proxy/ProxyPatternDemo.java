package com.zx.demo.javaee.pattern.proxy;

/**
 * Title: ProxyPatternDemo
 * Description: 代理模式demo
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 10:43
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("ProxyPatternDemo.jpg");

        // 图像将从磁盘加载
        image.display();
        // 图像不需要从磁盘加载
        image.display();
    }
}
