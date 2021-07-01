package com.example.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/4
 * @Description:
 */
public class TestAQS {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }
}
