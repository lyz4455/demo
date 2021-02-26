package com.example.demo.controller.aopcontroller;

import java.lang.annotation.*;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-02-26 15:13
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    AuthCheckEnum checkPermission() default AuthCheckEnum.CHECK;

}
