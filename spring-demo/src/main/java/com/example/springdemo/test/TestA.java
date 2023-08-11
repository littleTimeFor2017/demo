package com.example.springdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bruce Lee
 * @date 2021/7/5
 * @description
 **/
@Component
public class TestA {

    @Autowired
    private TestB testB;

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
