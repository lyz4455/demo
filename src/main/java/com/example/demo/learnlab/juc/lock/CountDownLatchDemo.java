package com.example.demo.learnlab.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-08-31 10:59
 */
public class CountDownLatchDemo {

    volatile List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        CountDownLatch countDown = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            if (countDownLatchDemo.size() != 5) {
                try {
                    countDown.await();
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                countDownLatchDemo.add(i);
                System.out.println("add:"+i);
                if (countDownLatchDemo.size() == 5) {
                    countDown.countDown();
                }
            }
            System.out.println("t1 end");
        }, "t1").start();


    }

}
