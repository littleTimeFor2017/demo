package com.example.test;

import java.math.BigInteger;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/13
 * @Description:
 */
public class Test {

    public boolean getResult() {
        System.out.println("进入到后面方法中");
        return true;
    }


    public static void main(String[] args) {
        Test test = new Test();
        if (test == null || test.getResult()) {
            System.out.println("123");
        }

        System.out.println(new BigInteger(String.valueOf(Long.valueOf(0))).toString(16));
    }


}
