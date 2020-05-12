package com.zx.demo.javaee.annotation;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: AnnotationTest
 * Description: AnnotationTest
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/5/12 11:08
 */
@Slf4j
public class AnnotationTest {

    public static void main(String[] args) {
        User user = AnnotationFactory.create();
        log.info(user.getName());
    }
}
