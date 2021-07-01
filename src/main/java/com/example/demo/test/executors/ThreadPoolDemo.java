package com.example.demo.test.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-01-27 17:26
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建线程池对象
        //获取系统处理器个数，作为线程池数量
        int nThreads = Runtime.getRuntime().availableProcessors();
//        ExecutorService service = Executors.newFixedThreadPool(nThreads);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService service = new ThreadPoolExecutor(nThreads, nThreads*2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(50), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        // 创建Runnable实例对象
        MyRunnable r = new MyRunnable();
        MyThread t = new MyThread();
        MyCallable c = new MyCallable();
        try {
            service.submit(r);
            service.execute(r);
            Future a =service.submit(r);
            Future b =service.submit(c);
            service.submit(t);
            service.submit(t);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
