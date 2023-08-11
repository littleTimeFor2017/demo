package com.example.springdemo.testlistener;

public class MainClass {

    public static void main(String[] args) {
        Multicaster multicaster = new MyMulticaster();
        multicaster.addListeners(new MyListener());
        multicaster.multiCastEvent(new Event("asdf"));
    }
}
