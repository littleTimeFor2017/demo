package com.example.springdemo.testdependson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
    }
}
