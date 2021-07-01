package com.example.jmm;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/29
 * @Description: 测试原子性
 * volatile 只能保证可见性和有序性，滥用的话可能会导致总线风暴；并不保证原子性
 */
public class TestAtomic {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter++;
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
