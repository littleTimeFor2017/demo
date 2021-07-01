package com.example.juc;

import org.aspectj.lang.reflect.LockSignature;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/12
 * @Description:
 */
public class TreadDemo {

    /**
     * //线程是无法中断的，interrupt只是设置了一个中断的标志，那么线程还继续存活吗？
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            //判断调用者线程的中断状态。
//            while (!Thread.currentThread().isInterrupted()) {
////                System.out.println("正常业务处理中");
////            }
            //线程
            LockSupport.park();
            System.out.println("阻塞状态已经被解除");
            System.out.println(Thread.interrupted());
        }, "t1");
        t1.start();
//        将调用者线程的中断状态设为true。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
//        LockSupport.unpark(t1);
    }
}
