package com.example.springdemo.testlistener;

public class MyListener implements Listener {
    @Override
    public void onEvent(Event e) {
        System.out.println("我是事件监听器，我监听到了广播器广播的事件：" + e);
    }
}
