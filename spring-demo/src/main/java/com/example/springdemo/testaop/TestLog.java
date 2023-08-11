package com.example.springdemo.testaop;

import org.springframework.stereotype.Component;

@Component
public class TestLog implements TestLogInterface {

    @Override
    public String debug() {
        System.out.println("TestLog>>>进入debug方法");
        return "debug";
    }


    @Override
    public String info() {
//        System.out.println(1/0);
        System.out.println("info");
        return "info";
    }


    @Override
    public String error() {
        System.out.println("TestLog>>>进入error方法");
        return "error";
    }
}
