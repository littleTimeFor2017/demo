package com.example.springdemo.testaop;

import org.springframework.stereotype.Component;

@Component
public class TestLog implements TestLogInterface {

    @Override
    public void debug() {
        System.out.println("TestLog>>>进入debug方法");
    }


    @Override
    public void info() {
//        System.out.println(1/0);
        System.out.println("info");
    }


    @Override
    public void error() {
        System.out.println("TestLog>>>进入error方法");
    }
}
