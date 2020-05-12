package com.zx.demo.javaee.pattern.observer;

/**
 * Title: Observer
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:31
 */
public interface Observer {

    void update(int value);

    void print();
}
