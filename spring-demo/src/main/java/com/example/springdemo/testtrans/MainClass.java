package com.example.springdemo.testtrans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/5
 * @Description:
 */

public class MainClass {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TestService testService = (TestService) context.getBean("testServiceImpl");
        testService.query();


    }
}
