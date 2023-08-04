package com.example.mybatisdemo.log;

import org.apache.ibatis.logging.Log;

public class TestLog implements Log {
    //必须得有一个带有参数的构造方法
    public TestLog(String clazz) {
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void error(String s, Throwable e) {
        System.out.println(s);
    }

    @Override
    public void error(String s) {
        System.out.println(s);
    }

    @Override
    public void debug(String s) {
        System.out.println(s);
    }

    @Override
    public void trace(String s) {
        System.out.println(s);
    }

    @Override
    public void warn(String s) {
        System.out.println(s);
    }
}
