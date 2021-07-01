package com.example.jmm;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/29
 * @Description: 测试死锁 以及如何定位死锁
 * jps 命令用来查找所有java进程pid的命令
 * jps -l 输出应用程序 main class的完整package名或者应用程序的jar文件的完整路径名
 * jps -v  输出传递给JVM的参数
 * jps -V 隐藏传递给JVM的参数
 * jps -q 只显示pid
 * jstack  查询一些死锁的信息
 * jstack [pid]
 */
public class TestDeadThread {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("t1 get lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("t1 get lock2");
                }
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("t2 get lock2");
                synchronized (lock1) {
                    System.out.println("t2 get lock1");
                }
            }
        }, "t2").start();
    }
}
