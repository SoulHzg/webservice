package com.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class AopProxy {
    /*@Pointcut("execution(* com.bestnet.services.*.*.*(..))")
    public void addPointcut(){};

    @Before("addPointcut()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("In AopProxy before ... ,method name is"+methodName);
    }

    @After("addPointcut()")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("In AopProxy after ... ,method name is"+methodName);
    }

    @AfterReturning(value = "addPointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,String result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("In AopProxy afterReturning ... ,method name is"+methodName);
        System.out.println("In AopProxy afterReturning ... ,method result is"+result);
    }*/

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("In AopProxy around-before...,method name is "+methodName);
        Object object = proceedingJoinPoint.proceed();
        System.out.println("In AopProxy afterRunning...,method name is "+methodName);
        System.out.println("In AopProxy around-after...,method name is "+methodName);
        return object;
    }
}
