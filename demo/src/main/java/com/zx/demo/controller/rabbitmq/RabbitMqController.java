package com.zx.demo.controller.rabbitmq;

import com.zx.demo.bean.mq.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: RabbitMqController
 * Description: RabbitMqController
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/6/5 15:41
 */
@RestController
@RequestMapping(value = "/mq")
public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 请求接口
     * @param message message
     * @return success
     */
    @PostMapping("/msg")
    public Object senAndRec(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(message.getExchangeName(), message.getRouterKey(), message.getMessage());
        return "success";
    }
}
