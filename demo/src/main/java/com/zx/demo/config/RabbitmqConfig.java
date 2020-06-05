package com.zx.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Title: RabbitmqConfig
 * Description: ActiveMQ配置
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/4 18:01
 */
@Configuration
public class RabbitmqConfig {

    @Bean(name = "okong")
    public Queue queue() {
        //创建一个消息队列
        return new Queue("topic.okong");
    }

    @Bean(name = "qune")
    public Queue qune() {
        //创建一个消息队列
        return new Queue("topic.qune");
    }

    @Bean
    TopicExchange topicExchange() {
        /** 配置路由器为Topic模式 */
        return new TopicExchange("topic");
    }

    @Bean
    Binding bindingExchangeA(@Qualifier("okong") Queue queue, TopicExchange topicExchange) {
        /**
         * 配置该消息队列的  routingKey
         * topic.* 匹配 第一个.后面的单词    代表      一个    单词
         * 比如 topic.asd 会被该消息队列接受 topic.asd.dsf不会被该消息队列接受
         */
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.*");
    }

    @Bean
    Binding bindingExchangeB(@Qualifier("qune") Queue qune, TopicExchange topicExchange) {
        /**
         * 配置该消息队列的  routingKey
         * topic.# 匹配 所有.后面的单词     代表     任意    个      单词
         * 比如 topic.asd 会被该消息队列接受 topic.asd.dsf也会被该消息队列接受
         */
        return BindingBuilder.bind(qune).to(topicExchange).with("topic.#");
    }
}
