package com.example.demo.test.thread;

import lombok.Data;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-05-26 17:40
 */

public class ThreadLocalDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第一个线程");
            msg.setAge(1);
            Channel.setMessage(msg);
            Channel.send();
        }, "线程A").start();

        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第二个线程");
            msg.setAge(2);
            Channel.setMessage(msg);
            Channel.send();
        }, "线程B").start();

        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第三个线程");
            msg.setAge(3);
            Channel.setMessage(msg);
            Channel.send();
        }, "线程C").start();

    }
}

@Data
class Message {
    private String info;

    private Integer age;
}

//class Channel {
//    private static Message message;
//
//    private Channel() {
//    }
//
//    public static void setMessage(Message m) {
//        message = m;
//    }
//
//    public static void send() {
//        System.out.println("【" + Thread.currentThread().getName() + "发送消息：】" + message.getInfo()+ message.getAge());
//    }
//}
class Channel {
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<>();
    private static Message message;

    private Channel() {
    }

    public static void setMessage(Message m) {
        THREAD_LOCAL.set(m);
    }

    public static void send() {
        System.out.println("【" + Thread.currentThread().getName() + "发送消息：】" + THREAD_LOCAL.get().getInfo() +THREAD_LOCAL.get().getAge());
    }
}


