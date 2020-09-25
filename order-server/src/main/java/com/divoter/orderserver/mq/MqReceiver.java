package com.divoter.orderserver.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @ClassName MqReceiver
 * @Description rabbitMq 接收方
 * @Authour Divoter
 * @Date 2020/9/25 13:16
 * @Version 1.0
 */
@Component
public class MqReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqReceiver.class);

    // 绑定消息队列
    // @RabbitListener(queues = "myQueue")
    // 自动创建队列
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 自动创建Exchange 和Queue 绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        logger.info("MqReceiver: {}",message);
    }

    /**
     * 电脑消息 接收方
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            key = "computer",
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder")

    ))
    public void processComputer(String message){
        logger.info("computer MqReceiver: {}",message);
    }


    /**
     * 水果消息接收方
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            key = "fruit",
            value = @Queue("fruitOrder"),
            exchange = @Exchange("myOrder")

    ))
    public void processFruit(String message){
        logger.info("fruit MqReceiver: {}",message);
    }
}
