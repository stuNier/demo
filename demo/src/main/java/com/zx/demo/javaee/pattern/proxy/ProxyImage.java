package com.zx.demo.javaee.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: ProxyImage
 * Description: 代理类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 10:44
 */
@Slf4j
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        log.info("前置");
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
        log.info("后置");
    }
}