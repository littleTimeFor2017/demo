package com.example.springdemo.testlistener;

import java.util.ArrayList;
import java.util.List;

public class MyMulticaster implements Multicaster {

    private List<Listener> listeners = new ArrayList<>();

    @Override
    public void addListeners(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void multiCastEvent(Event event) {
        System.out.println("开始广播事件.....");
        for (Listener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
