package com.example.demo.controller.aopcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-02-26 14:16
 */
@RestController

public class HelloController {

    @MyAnnotation(checkPermission= AuthCheckEnum.SKIP)
    @RequestMapping("/add1")
    public String addData1(String deviceId) {
        return "success";
    }

    @MyAnnotation(checkPermission= AuthCheckEnum.CHECK)
    @RequestMapping("/add2")
    public String addData2(String deviceId) {
        return "success";
    }

    @RequestMapping("/add3")
    public String addData3(String deviceId) {
        return "success";
    }

}
