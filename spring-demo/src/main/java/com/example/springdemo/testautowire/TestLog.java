package com.example.springdemo.testautowire;

import org.springframework.stereotype.Component;

@Component
public class TestLog implements TestLogInterface {

    public void debug() {
        System.out.println("TestLog>>>进入debug方法");
    }


    public void info() {
        System.out.println("TestLog>>>>进入info方法");
    }


    public void error() {
        System.out.println("TestLog>>>进入error方法");
    }
}
