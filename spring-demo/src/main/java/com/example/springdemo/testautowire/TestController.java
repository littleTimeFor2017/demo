package com.example.springdemo.testautowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 15:06
 * @Description:
 */
public class TestController {

    @Autowired
//    @Qualifier(value = "testService1")
    private TestService testService;

    @Autowired
    private TestService testService1;


    public void test() {
        System.out.println(testService);
        System.out.println(testService1);
    }

}
