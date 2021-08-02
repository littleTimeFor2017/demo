package com.example.test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.core.NamedThreadLocal;

/**
 * @author Bruce Lee
 * @date 2021/7/29
 * @description
 **/
public class ThreadLocalTest implements DisposableBean {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadLocalTest(String name) {
        this.name = name;
    }

    //声明线程变量
    private static final ThreadLocal<ThreadLocalTest> testHolder =
            new NamedThreadLocal<>("Current aspect-driven transaction");

    //声明线程变量
    private static final ThreadLocal<String> NAMED_THREAD_LOCAL =
            new NamedThreadLocal<>("name thread local");

    @Override
    public void destroy() throws Exception {
        testHolder.remove();
        NAMED_THREAD_LOCAL.remove();
    }

    public static void main(String[] args) {
        ThreadLocalTest lixc = new ThreadLocalTest("lixc");
        ThreadLocalTest.NAMED_THREAD_LOCAL.set("123");
        String  oldName = ThreadLocalTest.NAMED_THREAD_LOCAL.get();
        System.out.println(lixc.getName());
    }
}
