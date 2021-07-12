package com.example.demo.learnlab.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-05-28 15:42
 */
public class StarProxy implements InvocationHandler {
    // 目标类，也就是被代理对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以做增强
        System.out.println("收钱");

        Object result = method.invoke(target, args);

        return result;
    }

    // 生成代理类
    public Object CreatProxyedObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Star proxy(Object proxyObj) {
//        Star ldh = new LiuDeHua();
        StarProxy proxy = new StarProxy();
        proxy.setTarget(proxyObj);
        Object obj = proxy.CreatProxyedObj();
        Star star = (Star) obj;
        return star;
    }

    public static void main(String[] args) {
        Star ldh = new LiuDeHua();
        StarProxy proxy = new StarProxy();
        Star star= proxy.proxy(ldh);
        System.out.println(star.sing("1"));
    }

}
