package com.example.springdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bruce Lee
 * @date 2021/7/5
 * @description
 **/
@Component
public class TestB {

    @Autowired
    private TestA testA;


    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
