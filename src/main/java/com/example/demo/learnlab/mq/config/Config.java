package com.example.demo.learnlab.mq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-12 15:09
 */
@Configuration
public class Config {

    @Bean(name = "queue2")
    public Queue queue2() {
        return new ActiveMQQueue("active.queue2");
    }

    @Bean(name = "queue1")
    public Queue queue1() {
        return new ActiveMQQueue("active.queue1");
    }

}
