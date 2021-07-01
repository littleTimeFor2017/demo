package com.example.springdemo.testautowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 15:11
 * @Description:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TestController testController = (TestController) context.getBean("testController");
        testController.test();
    }
}
