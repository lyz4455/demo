package com.example.demo.learnlab.juc.executors;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-01-27 17:26
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("r我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("r教练来了： " + Thread.currentThread().getName());
        System.out.println("r教我游泳,交完后，教练回到了游泳池");
    }
}
