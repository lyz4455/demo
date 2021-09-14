package com.example.demo.learnlab.juc.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("c教练来了： " + Thread.currentThread().getName());
        System.out.println("c教我游泳,交完后，教练回到了游泳池");
        return i; //call方法可以有返回值
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // futureTask是 callable和runnable之间的桥梁
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println("get阻塞前");
        System.out.println(futureTask.get());
        System.out.println("get阻塞后");
    }
}
