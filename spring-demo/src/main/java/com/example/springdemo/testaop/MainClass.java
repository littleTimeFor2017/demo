package com.example.springdemo.testaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TestLogInterface testLog = (TestLogInterface) context.getBean("testLog");
//        TestLog testLog = new TestLog();
//        ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();
//        Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(testLog.getClass(), defaultClassLoader);
//        System.out.println(allInterfacesForClass[0]);
        testLog.info();
    }
}
