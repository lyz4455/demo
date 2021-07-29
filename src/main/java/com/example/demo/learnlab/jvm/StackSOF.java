package com.example.demo.learnlab.jvm;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-23 17:15
 */
public class StackSOF {

    private int a = 1;

    public void stackLeak(){
        a++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();
        stackSOF.stackLeak();
    }
}
