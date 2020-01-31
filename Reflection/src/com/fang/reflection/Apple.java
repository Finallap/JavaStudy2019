package com.fang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Apple {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setPrice(10);
        System.out.println("com.fang.reflection.Apple Price:" + apple.getPrice());

        try {
            Class clz = Class.forName("com.fang.reflection.Apple");
            Method setPriceMethod = clz.getMethod("setPrice", int.class);
            Constructor appleConstructor = clz.getConstructor();
            Object object = appleConstructor.newInstance();
            setPriceMethod.invoke(object, 10);
            Method getPriceMethod = clz.getDeclaredMethod("getPrice");
            System.out.println("com.fang.reflection.Apple Price:" + getPriceMethod.invoke(object));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
