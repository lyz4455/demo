package com.example.demo.learnlab;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-28 11:39
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {
    }

    /**
     * 双重校验锁
     *
     * @return Singleton
     */
    public static Singleton getSingleton() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Singleton.getSingleton())).start();
        new Thread(() -> System.out.println(Singleton.getSingleton())).start();
        new Thread(() -> System.out.println(Singleton.getSingleton())).start();
    }
}
