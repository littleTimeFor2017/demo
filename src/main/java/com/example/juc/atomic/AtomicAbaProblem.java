package com.example.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/7
 * @Description:
 */
public class AtomicAbaProblem {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> {
            int a = atomicInteger.get();
            System.out.println(Thread.currentThread().getName() + "获取的元数据为：" + a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isCasSuccess = atomicInteger.compareAndSet(a, 2);
            if (isCasSuccess) {
                System.out.println("修改成功，结果为：" + atomicInteger.get());
            } else {
                System.out.println("修改失败");
            }
        }, "主线程").start();


        new Thread(() -> {
            int i = atomicInteger.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + "incrementAndGet ：" + i);
            i = atomicInteger.decrementAndGet();
            System.out.println(Thread.currentThread().getName() + "decrementAndGet ：" + i);
        }, "干扰线程").start();
    }

}
