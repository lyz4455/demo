package com.example.demo.controller.test;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-08-04 17:12
 */
public class MonitorDemo {
    private int a = 0;

    public synchronized void writer() {     // 1
        a++;                                // 2
    }                                       // 3

    public synchronized void reader() {    // 4
        int i = a;                         // 5
    }                                      // 6
    public static void main(String[] args) {

        MonitorDemo demo1 = new MonitorDemo();
        new Thread(()->{
            demo1.writer();
            System.out.println(demo1.a);
        }).start();

        new Thread(()->{
            demo1.writer();
            System.out.println(demo1.a);
        }).start();
    }

}


