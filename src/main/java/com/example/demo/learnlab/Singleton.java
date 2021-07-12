package com.example.demo.learnlab;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-28 11:39
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static synchronized Singleton getSingleton(){
//        if(null == singleton){
//            singleton = new Singleton();
//        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Singleton.getSingleton())).start();

        System.out.println();
    }
}
