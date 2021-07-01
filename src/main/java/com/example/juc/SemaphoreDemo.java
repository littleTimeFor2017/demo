package com.example.juc;

import java.util.concurrent.Semaphore;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/6
 * @Description: Semaphore 信号量控制，使用场景：限流，限制最大的并发访问量
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //permits 表示有2个许可，当有多个线程访问时，只有拿到许可的线程才能继续往下走
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Test(semaphore, String.valueOf(i)).start();
        }
    }


    static class Test extends Thread {
        private Semaphore semaphore;

        public Test(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            super.setName(name);
        }

        @Override
        public void run() {
            try {
                //获取许可
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "acquire at time :" + System.currentTimeMillis());
                Thread.sleep(5000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "release at time :" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
