package com.example.springdemo.testbeanlifycycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 只有此bean作为singleton的时候会执行饿汉模式加载，spring管理销毁方法（调用本类的@PreDestroy标注的方法）
 * 当为原型模式的bean时，懒加载，jvm负责销毁
 */
//@Component
public class Book {

    public Book() {
        System.out.println("book 构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("Book 的PostConstruct方法 ");
    }


    @PreDestroy
    public void destroy() {
        System.out.println("Bool 的PreDestroy方法");
    }
}
