package com.example.springdemo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:41
 * @Description:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TestB TestB = (TestB) context.getBean("testB");
        TestA TestA = (TestA) context.getBean("testA");
        System.out.println(TestB);
        System.out.println(TestA);
        System.out.println(TestB.getTestA());
//            System.out.println(testBean);
    }
}
