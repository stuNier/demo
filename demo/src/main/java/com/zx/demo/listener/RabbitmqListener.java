package com.zx.demo.listener;

import com.rabbitmq.client.Channel;
import com.zx.demo.bean.mq.Message;
import com.zx.demo.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Title: RabbitmqListener
 * Description: 消费者
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

    /**
     * 消费者获取消息 队列1
     *
     * @param msg 消息
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_FIRST)
    public void processMessage1(String msg) {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.QUEUE_FIRST, msg);
    }

    /**
     * 消费者获取消息 队列2
     *
     * @param msg 消息
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_SECEND)
    public void processMessage2(String msg) {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.QUEUE_SECEND, msg);
    }

    /**
     * order消息消费者
     *
     * @param msg msg
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_ORDER)
    public void orderMessageListener(String msg, Channel channel, @Headers Map<String, Object> map) {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.QUEUE_ORDER, msg);
        if("error".equals(msg)){
            try {
                /** b1 false不在重回队列 */
                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, false);
                log.info("否认消息");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }else{
            try {
                channel.basicAck((Long) map.get(AmqpHeaders.DELIVERY_TAG), false);
                log.info("确认消息");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

}
