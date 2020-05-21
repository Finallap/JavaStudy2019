package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @description: LoggerAspect
 * @date: 2020/5/21 10:55
 * @author: Finallap
 * @version: 1.0
 */
@Aspect//该标签把LoggerAspect类声明为一个切面
@Component//该标签把LoggerAspect类放到IOC容器中
public class LoggerAspect {
    @Pointcut(value = "execution(public * com.controller.*Controller.*(..))")
    public void declareJoinPointExpression() {

    }

    @Before(value = "declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("this method " + methodName + " begin. param<" + args + ">");
    }

    /**
     * 环绕通知的aop程序，一定要记得将值返回回去，否则将获取不到Controller结果
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " start. param<" + Arrays.asList(proceedingJoinPoint.getArgs()) + ">");
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method " + methodName + " end. result<" + result + ">");
        } catch (Throwable e) {
            System.out.println("this method " + methodName + " end.ex message<" + e + ">");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("This method " + methodName + "end");
        return result;
    }

    @After(value = "declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method " + methodName + " end.");
    }

    @AfterReturning(value = "declareJoinPointExpression()", returning = "result")
    public void afterRetuning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method " + methodName + " end.result<" + result + ">");
    }

    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("this method " + methodName + " end.ex message<" + ex + ">");
    }

}
