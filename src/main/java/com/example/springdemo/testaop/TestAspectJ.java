package com.example.springdemo.testaop;


import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@Aspect
public class TestAspectJ {

    @Value("1234")
    private String name;

    @Pointcut("execution(* com.example.springdemo.testaop.TestLog.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void methodBefore() {
        System.out.println("进入methodBefore方法");
    }

    @After("pointCut()")
    public void methodAfter() {
        System.out.println("methodAfter");
    }

    @AfterReturning("pointCut()")
    public void methodAfterReturning() {
        System.out.println("methodAfterReturning");
    }

    @AfterThrowing("pointCut()")
    public void methodAfterThrowing() {
        System.out.println("methodAfterThrowing");
    }

}
