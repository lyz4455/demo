package com.example.demo.learnlab.mq.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-12 15:12
 */
@RestController
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired()
    @Qualifier("queue2")
    private Queue queue2;

    @Resource(name = "queue1")
    private Queue queue1;

    @GetMapping("/queue2")
    public void sendMessage1(String message) {
        jmsMessagingTemplate.convertAndSend(queue2, "I'm from queue2:" + message);
    }

    @GetMapping("/queue1")
    public void sendMessage2(String message) {
        jmsMessagingTemplate.convertAndSend(queue1, "I'm from queue1:" + message);
    }
}
