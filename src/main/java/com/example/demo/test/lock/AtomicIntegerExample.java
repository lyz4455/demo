package com.example.demo.test.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-28 10:49
 */
public class AtomicIntegerExample {

    private AtomicInteger sycValue = new AtomicInteger(0);

    private static final int MAX_SYC_VALUE = 3 * 10;

    public static void main(String[] args) {

        AtomicIntegerExample example = new AtomicIntegerExample();
//        ExecutorService service = Executors.newFixedThreadPool(3);

        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = new ThreadPoolExecutor(nThreads, nThreads*2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024));



        service.execute(example.new RunnableA());
        service.execute(example.new RunnableB());
        service.execute(example.new RunnableC());

        service.shutdown();

    }

    private class RunnableA implements Runnable {
        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 0) {
                    System.out.print("A");
                    sycValue.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {
        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 1) {
                    System.out.print("B");
                    sycValue.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {
        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 2) {
                    System.out.print("C");
                    sycValue.getAndIncrement();
                }
            }

        }
    }
}
