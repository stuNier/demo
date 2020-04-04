package com.zx.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Title: JedisConfig
 * Description: Jedis配置
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/27 15:04
 */
@Slf4j
@Configuration
public class JedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    /*@Value("${spring.redis.password}")
    private String password;*/

    /**
     * redisPoolFactory
     * @return JedisPool
     */
    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
        log.info("JedisPool 注入成功！");
        return  jedisPool;
    }

}
