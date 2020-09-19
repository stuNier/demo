package com.zx.demo.javaee.pattern.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: Ford
 * Description: 福特
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:46
 */
@Slf4j
public class Ford implements Car{

    @Override
    public void start() {
        log.info("Ford start");
    }
}
