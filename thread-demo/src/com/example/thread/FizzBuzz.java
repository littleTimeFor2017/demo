package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private AtomicInteger integer = new AtomicInteger(1);


    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (integer.get() <= n) {
                int current = integer.get();
                if (current % 3 == 0 && current % 5 != 0) {
                    printFizz.run();
                    integer.incrementAndGet();
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (integer.get() <= n) {
                int current = integer.get();
                if (current % 3 != 0 && current % 5 == 0) {
                    printBuzz.run();
                    integer.incrementAndGet();
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (integer.get() <= n) {
                int current = integer.get();
                if (current % 3 == 0 && current % 5 == 0) {
                    printFizzBuzz.run();
                    integer.incrementAndGet();
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (integer.get() <= n) {
                int current = integer.get();
                if (current % 3 != 0 && current % 5 != 0) {
                    printNumber.accept(current);
                    integer.incrementAndGet();
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}