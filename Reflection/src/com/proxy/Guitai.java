package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Guitai implements InvocationHandler {
    private Object pingpai;

    public Guitai(Object pingpai) {
        this.pingpai = pingpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始，柜台是： " + this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("销售结束");
        return null;
    }
}
