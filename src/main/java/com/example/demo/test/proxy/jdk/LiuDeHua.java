package com.example.demo.test.proxy.jdk;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-05-28 15:40
 */
public class LiuDeHua implements Star {
    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");

        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马骝");

        return "跳完";
    }
}
