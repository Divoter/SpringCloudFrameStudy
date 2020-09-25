package com.divoter.orderserver.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName StreamReceiver
 * @Description
 * @Authour Divoter
 * @Date 2020/9/25 13:40
 * @Version 1.0
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StreamClient.class);
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)//接受到消息后，向StreamClient.INPUT2队列发送消息 ，告知已接受到
    public String  process(Object message){
        logger.info("StreamReceiver: {}",message);
        // 发送mq消息
        return "received.";
    }

    @StreamListener(StreamClient.INPUT2)
    public void process2(String message){
        logger.info("StreamReceiver2: {}",message);
    }
}
