package com.zx.demo.listener;

import com.rabbitmq.client.Channel;
import com.zx.demo.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
     * MANUAL_QUEUE
     * @param msg msg
     * @param channel channel
     * @param message message
     * @throws IOException IOException
     */
    @RabbitListener(queues = RabbitConfig.MANUAL_QUEUE)
    public void manualMessageListener(String msg, Channel channel, Message message) throws IOException {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.MANUAL_QUEUE, msg);
        if ("error".equals(msg)) {
            if (message.getMessageProperties().getRedelivered()) {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                log.info("重试失败，不再会队列");
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                log.info("否认消息，重试");
            }
        } else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("确认消息");
        }
    }


    /**
     * RETRY_QUEUE
     * @param msg msg
     * @param channel channel
     * @param message message
     * @throws IOException IOException
     */
    @RabbitListener(queues = RabbitConfig.RETRY_QUEUE)
    public void retryMessageListener(String msg, Channel channel, Message message) {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.RETRY_QUEUE, msg);
    }

    /**
     * FILED_QUEUE
     * @param msg msg
     * @param channel channel
     * @param message message
     * @throws IOException IOException
     */
    @RabbitListener(queues = RabbitConfig.FILED_QUEUE)
    public void filedMessageListener(String msg, Channel channel, Message message) {
        log.info("{} 接收到来自{}队列的消息：{}", Thread.currentThread().getName(), RabbitConfig.FILED_QUEUE, msg);
    }
}
