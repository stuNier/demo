package com.zx.java.designpattern.abstractfactorypattern.color;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: Red
 * Description:
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 10:52
 */
@Slf4j
public class Green implements Color {

    @Override
    public void draw() {
        log.info("Green");
    }
}
