package com.example.demo.learnlab.juc.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-09-13 11:09
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        //生产者
        producer(delayQueue);

        //消费者
        consumer(delayQueue);

        while (true) {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 每100毫秒创建一个对象，放入延迟队列，延迟时间1毫秒
     *
     * @param delayQueue
     */
    private static void producer(final DelayQueue<DelayedElement> delayQueue) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                DelayedElement element = new DelayedElement(1000, "test");
                delayQueue.offer(element);
            }
        }).start();

        /**
         * 每秒打印延迟队列中的对象个数
         */
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("delayQueue size:" + delayQueue.size());
            }
        }).start();
    }

    /**
     * 消费者，从延迟队列中获得数据,进行处理
     *
     * @param delayQueue
     */
    private static void consumer(final DelayQueue<DelayedElement> delayQueue) {
        new Thread(() -> {
            while (true) {
                DelayedElement element = null;
                try {
                    element = delayQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "---" + element);
            }
        }).start();
    }
}


