package com.example.demo.learnlab.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-05-31 11:35
 */
public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock();

    public static void test(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取了锁");
            TimeUnit.SECONDS.sleep(2);
//            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
    }
    public static void main(String[] args) {
        new Thread(() -> test(),"线程A").start();
        new Thread(() -> test(),"线程B").start();
    }
}
