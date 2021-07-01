package com.example.springdemo;

import org.junit.Test;

import java.util.Random;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/27
 * @Description:
 */
public class ShuiXianHuaTest {

    //假设水仙花有n位  循环n次

    @Test
    public void test1() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i * i * i + j * j * j + k * k * k == k * 100 + j * 10 + i) {
                        System.out.println(k * 100 + j * 10 + i);
                    }
                }
            }
        }
    }

    @Test
    public void test3() {
        int n = 3;
        for (int i = 0; i >= 3 && i <= n; i++) {

        }


        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i * i * i + j * j * j + k * k * k == k * 100 + j * 10 + i) {
                        System.out.println(k * 100 + j * 10 + i);
                    }
                }
            }
        }
    }


    /**
     * 左移表示乘阶的  只能是2
     */
    @Test
    public void test2() {
        System.out.println(1 << 2);
    }


    @Test
    public void test4() {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(9) + 1);
            System.out.println(new Random().nextInt(12) + 3);
            System.out.println(new Random().nextInt(994) + 5);
        }
    }

}
