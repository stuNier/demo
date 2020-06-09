package com.zx.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Title: RabbitTemplateConfirmConfig
 * Description: RabbitTemplateConfirmConfig
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/8 16:19
 */
@Slf4j
@Component
public class RabbitTemplateConfirmConfig implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * initRabbitTemplate
     */
    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setConfirmCallback(this);

    }

    /**
     * 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
     *
     * @param correlationData correlationData
     * @param ack             b
     * @param s               s
     */
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String s) {
        log.info("ack确认:{}" + ack);
        if (ack) {
            log.info("消息到达rabbitmq服务器");
        } else {
            log.info("消息可能未到达rabbitmq服务器");
        }
    }
}
