package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Maotai maotai = new Maotai();
        Wuliangye wuliangye = new Wuliangye();
        InvocationHandler jingxiao1 = new Guitai(maotai);
        InvocationHandler jingxiao2 = new Guitai(wuliangye);
        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(Maotai.class.getClassLoader(),
                Maotai.class.getInterfaces(), jingxiao1);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),
                Wuliangye.class.getInterfaces(), jingxiao2);
        dynamicProxy.mainJiu();
        dynamicProxy2.mainJiu();

        System.out.println(dynamicProxy.getClass().getName());
        System.out.println(dynamicProxy2.getClass().getName());
    }
}
