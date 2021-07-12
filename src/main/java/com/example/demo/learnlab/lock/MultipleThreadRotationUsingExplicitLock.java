package com.example.demo.learnlab.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-04 18:01
 */
public class MultipleThreadRotationUsingExplicitLock {
    public static void main(String[] args) {
        PrintABCUsingReentrantLock printABC = new PrintABCUsingReentrantLock();
        new Thread(() -> printABC.printA()).start();
        new Thread(() -> printABC.printB()).start();
        new Thread(() -> printABC.printC()).start();
    }

    static class PrintABCUsingReentrantLock {
        private Lock lock = new ReentrantLock();
        private int state = 0;

        //private int attempts =0;

        public void printA() {
            print("A", 0);
        }

        public void printB() {
            print("B", 1);
        }

        public void printC() {
            print("C", 2);
        }

        private void print(String name, int currentState) {
            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
                    //System.out.println(Thread.currentThread().getName()+" try to print "+name+", attempts : "+(++attempts));
                    while (state % 3 == currentState) {
                        System.out.println(Thread.currentThread().getName() + " print " + name);
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}


