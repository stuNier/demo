package com.zx.demo.controller.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: TestController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/5 15:41
 */
@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("sendTwo")
    public void sendTwo(String mes){
        amqpTemplate.convertAndSend("topic","topic.name.a",mes);
        amqpTemplate.convertAndSend("topic","topic.a",mes);
    }
}
