package com.zx.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Title: DemoApplication
 * Description: DemoApplication
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/23 11:18
 */
@SpringBootApplication
@MapperScan("com.thunisoft.demo.mapper")
public class DemoApplication {

    /**
     * 入口
     * @param args 入口参数
     * @return void
     * @author: zhengxin-3@thunisoft.com
     * date: 20-04-01 16:39
     * @version 1.0
     */
    public static void main(String[] args) {
        // 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(DemoApplication.class, args);
    }

}
