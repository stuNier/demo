package com.zx.demo.config;

import org.springframework.amqp.core.*;
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

    public static final String MANUAL_QUEUE = "manualQueue";
    public static final String RETRY_QUEUE = "retryQueue";
    public static final String FILED_QUEUE = "filedQueue";

    /** 正常的交换器 */
    private static final String MANUAL_EXCHANGE = "manualExchange";
    /** 重试交换器 */
    private static final String RETRY_EXCHANGE = "retryExchange";
    /** 失败交换器 */
    private static final String FILED_EXCHANGE = "filedExchange";

    private static final String MANUAL_ROUTING_KEY = "manual.#";
    private static final String RETRY_ROUTING_KEY = "retry.#";
    private static final String FILED_ROUTING_KEY = "filed.#";

    /**
     * MANUAL_QUEUE true表示持久化该队列
     *
     * @return 队列
     */
    @Bean
    public Queue manualQueue() {
        return new Queue(MANUAL_QUEUE, true);
    }

    /**
     * RETRY_QUEUE
     *
     * @return 队列
     */
    @Bean
    public Queue retryQueue() {
        return new Queue(RETRY_QUEUE, true);
    }

    /**
     * FILED_QUEUE
     *
     * @return 队列
     */
    @Bean
    public Queue filedQueue() {
        return new Queue(FILED_QUEUE, true);
    }

    /**
     * 声明交互器
     *
     * @return 正常的交换器
     */
    @Bean
    TopicExchange manualExchange() {
        return new TopicExchange(MANUAL_EXCHANGE);
    }

    /**
     * 声明重试交换器
     * @return 重试交换器
     */
    @Bean
    TopicExchange retryExchange(){
        return new TopicExchange(RETRY_EXCHANGE);
    }

    /**
     * 失败交换器
     * @return 失败交换器
     */
    @Bean
    TopicExchange failedExchange(){
        return new TopicExchange(FILED_EXCHANGE);
    }

    /**
     * 绑定 *匹配一个单词
     *
     * @return 绑定
     */
    @Bean
    public Binding bindingManual() {
        return BindingBuilder.bind(manualQueue()).to(manualExchange()).with(MANUAL_ROUTING_KEY);
    }

    /**
     * 绑定 #匹配所有单词 可以是0个单词
     *
     * @return 绑定
     */
    @Bean
    public Binding bindingRetry() {
        return BindingBuilder.bind(retryQueue()).to(manualExchange()).with(RETRY_ROUTING_KEY);
    }

    /**
     * order 绑定
     *
     * @return 绑定
     */
    @Bean
    public Binding bindingFiled() {
        return BindingBuilder.bind(filedQueue()).to(manualExchange()).with(FILED_ROUTING_KEY);
    }
}
