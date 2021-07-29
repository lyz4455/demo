package com.example.demo.learnlab.jvm;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-23 18:08
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){

        ReferenceCountingGC a = new ReferenceCountingGC();

        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;

        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
