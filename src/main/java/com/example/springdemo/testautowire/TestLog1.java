package com.example.springdemo.testautowire;

import org.springframework.stereotype.Component;

@Component
public class TestLog1 implements TestLogInterface {

    public void debug() {
        System.out.println("TestLog1>>>进入debug方法");
    }


    public void info() {
        System.out.println("TestLog1>>>进入info方法");
    }


    public void error() {
        System.out.println("TestLog1>>>进入error方法");
    }
}
