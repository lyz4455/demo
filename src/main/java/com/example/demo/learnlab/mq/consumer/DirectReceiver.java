//package com.example.demo.learnlab.mq.consumer;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * @author yanzhongliu
// * @email yanzhongliu@ctrip.com
// * @date 2021-07-14 19:23
// * @description 监听的队列名称 TestDirectQueue
// */
//
//@Component
//@RabbitListener(queues = "TestDirectQueue")
//public class DirectReceiver {
//
//    @RabbitHandler
//    public void process(Map testMessage) {
//        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
//    }
//
//}
