package com.example.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/11
 * @Description:
 */
public class ReentrantLockDemo {

    //默认为非公平锁
    private static final Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        lock.lock();
        try {
            //获取锁以后的处理逻辑
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
