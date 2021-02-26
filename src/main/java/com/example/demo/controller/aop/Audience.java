package com.example.demo.controller.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-07-16 14:45
 */
@Aspect
public class Audience {
    @Pointcut("execution(* Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhone(){
        System.out.println("关闭手机");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("坐座位");
    }
    @After("performance()")
    public void applause(){
        System.out.println("鼓掌");
    }
}
