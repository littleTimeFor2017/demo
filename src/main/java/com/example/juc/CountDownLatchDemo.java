package com.example.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/13
 * @Description:
 */
public class CountDownLatchDemo {


    static class Worker extends Thread {

        private CountDownLatch countDownLatch;
        private String name;

        public Worker(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            super.setName(name);
        }

        @Override
        public void run() {
            System.out.println("子线程" + Thread.currentThread().getName() + "-----countDown");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Worker(countDownLatch, String.valueOf(i)).start();
        }
        try {
            System.out.println("主线程开始等待");
            countDownLatch.await();
            System.out.println("主线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
