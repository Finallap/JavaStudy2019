package com.fang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectClass {
    private final static String TAG = "com.fang.reflection.ReflectClass";

    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.fang.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setAuthor("方垣闰");
            book.setName("Java Reflection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Book book = new Book("方垣闰", "Java Reflection");
        Class c1 = book.getClass();
        Class c2 = Book.class;
        Class c3 = Class.forName("com.fang.reflection.Book");

        System.out.println(c1 == c2);
        System.out.println(c1.getSimpleName());

        Method[] methods = c1.getDeclaredMethods();

        for (Method method : methods) {
            Class m = method.getReturnType();

            System.out.println("方法名称：" + method.getName());
            System.out.println("返回值类型：" + m.getName());
        }

        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("成员变量名称：" + field.getName());
            System.out.println("成员变量类型：" + field.getType());
        }

        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("构造函数名称：" + constructor.getName());
        }
    }
}
