package com.divoter.orderserver.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName MqController
 * @Description
 * @Authour Divoter
 * @Date 2020/9/25 13:51
 * @Version 1.0
 */
@RestController
public class MqController {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    public void sendOrder() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
    }
}
