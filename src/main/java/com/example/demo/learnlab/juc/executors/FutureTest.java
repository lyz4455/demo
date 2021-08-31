package com.example.demo.learnlab.juc.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class FutureTest {

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
        MyCallable c = new MyCallable();
        try {
            Future b =service.submit(c);
            Future a =service.submit(c);
            Future d =service.submit(c);
            b.get();
            a.get();
            d.get();
            System.out.println("h");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
