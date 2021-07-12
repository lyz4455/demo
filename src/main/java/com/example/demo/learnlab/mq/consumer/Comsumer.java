package com.example.demo.learnlab.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-12 15:13
 */
@Component
public class Comsumer {

    /**
     * 接受消息队列1消息
     * @param message
     */
    @JmsListener(destination = "active.queue1")
    public void readActiveQueue11(String message) {
        System.out.println(1 + message);
    }

    /**
     * 接受消息队列1消息
     * @param message
     */
    @JmsListener(destination = "active.queue1")
    public void readActiveQueue12(String message) {
        System.out.println(2 + message);
    }

    /**
     * 接受消息队列2消息
     * @param message
     */
    @JmsListener(destination = "active.queue2")
    public void readActiveQueue21(String message) {
        System.out.println(1 + message);
    }

    /**
     * 接受消息队列2消息
     * @param message
     */
    @JmsListener(destination = "active.queue2")
    public void readActiveQueue22(String message) {
        System.out.println(2 + message);
    }
}
