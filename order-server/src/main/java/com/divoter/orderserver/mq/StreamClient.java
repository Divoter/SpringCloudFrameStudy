package com.divoter.orderserver.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName StreamClient
 * @Description
 * @Authour Divoter
 * @Date 2020/9/25 13:38
 * @Version 1.0
 */
public interface StreamClient {
    String INPUT="myMessage";
    String INPUT2="myMessage2";
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();
    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.INPUT2)
    MessageChannel output2();
}
