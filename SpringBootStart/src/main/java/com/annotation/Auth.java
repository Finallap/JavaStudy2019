package com.annotation;

import java.lang.annotation.*;

/**
 * @description: Auth
 * @date: 2020/5/21 19:23
 * @author: Finallap
 * @version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface Auth {
    String value(); //注解的属性，如果只有一个属性，一般叫value

    String name() default ""; //属性，默认值""，可以不写
}
