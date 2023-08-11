package com.example.springdemo.testlistener;

/**
 * 事件监听者
 */
public interface Listener {
    /**
     * 接收到事件广播器广播的事件，对事件进行处理
     *
     * @param e 事件
     */
    void onEvent(Event e);
}
