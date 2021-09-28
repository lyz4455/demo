package com.example.demo.learnlab;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-09-27 20:16
 */
public class Txtext {

    AtomicInteger i = new AtomicInteger(1);

    void printOne() {
        while (i.get() <= 100) {
            while (i.get() % 3 == 1) {
                Thread t = Thread.currentThread();
                System.out.println(t + ":" + i);
                i.getAndIncrement();
            }
        }
    }

    void printTwo() {
        while (i.get() <= 100) {
            while (i.get() % 3 == 2) {
                Thread t = Thread.currentThread();
                System.out.println(t + ":" + i);
                i.getAndIncrement();
            }
        }
    }

    void printThree() {
        while (i.get() <= 100) {
            while (i.get() % 3 == 0) {
                Thread t = Thread.currentThread();
                System.out.println(t + ":" + i);
                i.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        Txtext txtext = new Txtext();
        new Thread(() -> {
            txtext.printOne();
        }, "a").start();

        new Thread(() -> {
            txtext.printTwo();
        }, "b").start();

        new Thread(() -> {
            txtext.printThree();
        }, "c").start();
    }
}
