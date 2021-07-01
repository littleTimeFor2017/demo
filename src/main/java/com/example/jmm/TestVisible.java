package com.example.jmm;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/29
 * @Description: 测试可见性
 * test1：当t1开始运行时，将initFlag的值读取到它的本地内存中， t1对应的内核一直在自旋；当t2修改了主内存中的值时，t1并不会接受到通知，因此t1一直沉浸在自己的死循环中
 * test2: 当增加了synchronized(lock)时，会发生锁的竞争，发生上下文切换，此时就有可能会重新从内存中读取值？？这块还不是很理解
 */
public class TestVisible {
    private static boolean initFlag = false;
    //test2
    private static final Object lock = new Object();


    public static void main(String[] args) {

        new Thread(() -> {
            int i = 0;
            while (!initFlag) {
                //test2
                synchronized (lock) {
                    i++;
                }
            }
            System.out.println("t1线程接收到了initFlag的改变，t1运行结束");
        }, "t1").start();


        new Thread(() -> {
            try {
                Thread.sleep(100);
                initFlag = true;
                System.out.println("t2 线程修改了initFlag的值为true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

    }
}
