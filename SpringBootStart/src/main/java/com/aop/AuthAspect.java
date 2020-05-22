package com.aop;

import com.annotation.Auth;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description: AuthAspect
 * @date: 2020/5/21 19:30
 * @author: Finallap
 * @version: 1.0
 */
@Aspect
@Component
public class AuthAspect {
    @Pointcut("@annotation(com.annotation.Auth)")
    public void authAspect() {

    }

    @Before("authAspect()")
    public void beforeAuth() {
        System.out.println("触发到 @Before(\"beforeAuth()\")");
    }

    @AfterReturning("authAspect()")
    public void afterReturning(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        System.out.println("触发 @AfterReturning(\"authAspect()\")");
        System.out.println(args.length);
        getControllerMethodDescription(joinPoint);
    }

    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return 方法描述
     */
    public static void getControllerMethodDescription(JoinPoint joinPoint) {
        //获得执行方法的类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获得执行方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取切点方法的所有参数类型
        Object[] arguments = joinPoint.getArgs();
        try {
            Class targetClass = Class.forName(targetName);

            //获取公共方法，不包括类私有的
            Method[] methods = targetClass.getMethods();
            String value = "";
            String name = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    //对比方法中参数的个数
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        value = method.getAnnotation(Auth.class).value();
                        name = method.getAnnotation(Auth.class).name();
                        break;
                    }
                }
            }
            System.out.println("value=" + value);
            System.out.println("name=" + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
