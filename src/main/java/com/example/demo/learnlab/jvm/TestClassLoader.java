package com.example.demo.learnlab.jvm;

public class TestClassLoader {
    private static int a =1;
    private final static int c = 6;
    static {
        a = 100;
        b= 3;
    }
    private static int b =2;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        systemClassLoader.getParent();
    }
}
