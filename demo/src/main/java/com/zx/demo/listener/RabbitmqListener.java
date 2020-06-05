package com.zx.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title: RabbitmqListener
 * Description: RabbitmqListener
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/5 15:40
 */
@Slf4j
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "topic.qune")
    @RabbitHandler
    public void process(String mess) {
        log.info("我是topic.qune的消费者接收到的消息为 ：{}", mess);
    }

    @RabbitListener(queues = "topic.okong")
    @RabbitHandler
    public void okong(String mess) {
        log.info("我是topic.okong的消费者接收到的消息为：{}", mess);
    }

}
