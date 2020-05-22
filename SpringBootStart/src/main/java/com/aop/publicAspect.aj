package com.aop;

import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description: 以public aspect 方式定义的切面，但是好像不管用
 * @date: 2020/5/21 21:55
 * @author: Finallap
 * @version: 1.0
 */
@Aspect
@Component
public aspect publicAspect {
    pointcut controllerMethod():call(* com.controller.*Controller.*(..));
    pointcut annotation():@annotation(com.annotation.Auth);

    before():controllerMethod(){
        Signature signature = thisJoinPoint.getSignature();
        System.out.println("在调用" + signature.getName());
    }
}
