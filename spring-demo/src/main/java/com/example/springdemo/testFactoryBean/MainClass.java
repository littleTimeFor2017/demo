package com.example.springdemo.testFactoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:22
 * @Description:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(context.getBean("carFactory"));
        System.out.println(context.getBean("&carFactory"));
    }
}
