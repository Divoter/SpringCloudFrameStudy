package com.divoter.orderserver.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
public class SendMessageController {

    @Resource
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process() {
//        String message = "now " + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * 发送 orderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process() {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setOrderId("123456");
//        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
        String message = "now "+new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
}
