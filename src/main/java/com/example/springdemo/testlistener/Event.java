package com.example.springdemo.testlistener;

public class Event {
    public String name;
    public String content;

    public Event(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
