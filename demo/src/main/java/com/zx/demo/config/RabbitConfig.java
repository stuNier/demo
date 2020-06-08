package com.zx.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class RabbitConfig {

    public static final String QUEUE_FIRST = "queue1";

    public static final String QUEUE_SECEND = "queue2";

    public static final String QUEUE_ORDER = "orderQueue";

    private static final String EXCHANGE_NAME = "topicExchange";

    private static final String ORDER_ROUTING_KEY = "order.#";

    /**
     * 队列1
     *
     * @return 队列
     */
    @Bean
    public Queue queue1() {
        // true表示持久化该队列
        return new Queue(QUEUE_FIRST, true);
    }

    /**
     * 队列2
     *
     * @return 队列
     */
    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_SECEND, true);
    }

    /**
     * order queue
     *
     * @return order queue
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QUEUE_ORDER, true);
    }

    /**
     * 声明交互器
     *
     * @return topicExchange
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 绑定 *匹配一个单词
     *
     * @return 绑定
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("router.*");
    }

    /**
     * 绑定 #匹配所有单词 可以是0个单词
     *
     * @return 绑定
     */
    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("router.#");
    }

    /**
     * order 绑定
     * @return 绑定
     */
    @Bean
    public Binding orderBinding(){
        return BindingBuilder.bind(orderQueue()).to(topicExchange()).with(ORDER_ROUTING_KEY);
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }
}
