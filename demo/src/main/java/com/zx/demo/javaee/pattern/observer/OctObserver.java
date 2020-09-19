package com.zx.demo.javaee.pattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: OctObserver
 * Description: 十进制
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 14:39
 */
@Slf4j
public class OctObserver extends BaseObserver {

    public OctObserver(Subject subject){
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void update(int value) {
        this.data = Integer.toOctalString(value);
    }
}
