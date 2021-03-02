package com.example.demo.controller.interceptor;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-07-29 15:28
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/hello")
    public String getHello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }
}
