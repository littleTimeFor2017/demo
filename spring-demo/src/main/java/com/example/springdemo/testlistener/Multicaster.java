package com.example.springdemo.testlistener;

/**
 * 事件广播器
 */
public interface Multicaster {

    /**
     * 添加监听者
     */
    void addListeners(Listener listener);


    /**
     * 广播事件的动作
     * 把事件传递给事件监听者，由事件监听者去处理事件
     */
    void multiCastEvent(Event event);
}
