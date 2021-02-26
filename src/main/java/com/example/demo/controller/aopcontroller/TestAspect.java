package com.example.demo.controller.aopcontroller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-02-26 14:21
 */
@Aspect
@Component
public class TestAspect {

    /**
     * 方法1
     * @param pjp
     * @param myAnnotation
     * @return
     */
//    @Pointcut("execution(public * com.example.demo.controller.aopcontroller.HelloController.add*(..))&& @annotation(com.example.demo.controller.aopcontroller.MyAnnotation)")
//    public void addAdvice() {
//    }
//
//    @Before("addAdvice()")
//    public void startAuth() {
//        System.out.println("开始认证");
//    }
//
//    @Around(value = "addAdvice()&& @annotation(myAnnotation)")
//    public Object Interceptor(ProceedingJoinPoint pjp, MyAnnotation myAnnotation) {
//        if (myAnnotation.checkPermission().status() == 1) {
//            return "skip";
//        }
//        Object result = null;
//        Object[] args = pjp.getArgs();
//        if (args != null && args.length > 0) {
//            String deviceId = (String) args[0];
//            if (!"03".equals(deviceId)) {
//                return "no anthorization";
//            }
//        }
//        try {
//            result = pjp.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @After("addAdvice()")
//    public void endAuth() {
//        System.out.println("认证结束");
//    }

    /**
     * 方法2
     *
     * @param pjp
     * @param myAnnotation
     * @return
     */
    @Around("@annotation(myAnnotation)")
    public Object Interceptor(ProceedingJoinPoint pjp, MyAnnotation myAnnotation) {

        if (myAnnotation.checkPermission().status() == 1) {
            return "skip";
        }
        Object result = null;
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            String deviceId = (String) args[0];
            if (!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
