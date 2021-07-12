package com.example.demo.learnlab.executors;

import java.util.concurrent.Callable;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-01-27 17:26
 */
public class MyCallable implements Callable {
    int i = 999;

    @Override
    public Object call() {

        System.out.println("c我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("c教练来了： " + Thread.currentThread().getName());
        System.out.println("c教我游泳,交完后，教练回到了游泳池");
        return i; //call方法可以有返回值
    }
}
