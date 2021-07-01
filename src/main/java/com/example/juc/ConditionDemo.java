package com.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/14
 * @Description:
 */
public class ConditionDemo {

    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    public static void test() {
        try {
            notFull.await();
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
