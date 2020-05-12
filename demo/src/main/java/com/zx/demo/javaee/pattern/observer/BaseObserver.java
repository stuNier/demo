package com.zx.demo.javaee.pattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: BaseObserver
 * Description: 基础类
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:47
 */
@Slf4j
public abstract class BaseObserver implements Observer {

    protected Subject subject;

    protected String data;

    @Override
    public void print(){
        log.info(data);
    }
}
