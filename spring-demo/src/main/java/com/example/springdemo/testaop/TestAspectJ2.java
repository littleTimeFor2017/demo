package com.example.springdemo.testaop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Bruce Lee
 * @date 2021/7/16
 * @description
 **/
@Aspect
//@Order(value = 1)
public class TestAspectJ2 {

    @Value("1234")
    private String name;

    @Pointcut("execution(* com.example.springdemo.testaop.TestLog.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void methodBefore() {
        System.out.println("进入 TestAspectJ2 methodBefore方法");
    }

    @After("pointCut()")
    public void methodAfter() {
        System.out.println("TestAspectJ2 methodAfter");
    }

    @AfterReturning("pointCut()")
    public void methodAfterReturning() {
        System.out.println(" TestAspectJ2 methodAfterReturning");
    }

    @AfterThrowing("pointCut()")
    public void methodAfterThrowing() {
        System.out.println(" TestAspectJ2 methodAfterThrowing");
    }

//    @Around("pointCut()")
//    public void methodAround() {
//        System.out.println("TestAspectJ2 methodAround");
//    }
}
