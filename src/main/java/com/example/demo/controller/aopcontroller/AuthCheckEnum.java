package com.example.demo.controller.aopcontroller;


/**
 * @author yanzhongliu
 */

public enum AuthCheckEnum {
    CHECK(0),
    SKIP(1);

    private int status;

    private AuthCheckEnum(int status) {
        this.status = status;
    }

    public int status() {
        return status;
    }
}
