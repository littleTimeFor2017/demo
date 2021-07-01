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
            TestBean testBean = (TestBean) context.getBean("testBean");
            System.out.println(testBean);
        }
}
