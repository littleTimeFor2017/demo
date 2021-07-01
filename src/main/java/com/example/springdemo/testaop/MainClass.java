package com.example.springdemo.testaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TestLogInterface testLog = (TestLogInterface) context.getBean("testLog");
        testLog.info();
    }
}
