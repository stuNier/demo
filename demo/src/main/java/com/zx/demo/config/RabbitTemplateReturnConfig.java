package com.zx.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Title: RabbitTemplateReturnConfig
 * Description: RabbitTemplateReturnConfig
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/8 16:12
 */
@Slf4j
@Component
public class RabbitTemplateReturnConfig implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * initRabbitTemplate
     */
    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 启动消息失败返回，比如路由不到队列时触发回调
     *
     * @param message      message
     * @param replyCode    replyCode
     * @param replyText    replyText
     * @param exchangeName exchangeName
     * @param routingKey   routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchangeName, String routingKey) {
        log.info("回调");
    }
}
