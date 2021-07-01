package com.example.springdemo.testautowire;


/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 15:06
 * @Description:
 */
public class TestService {

    private int type;

    public TestService(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TestService{" +
                "type=" + type +
                '}';
    }
}
