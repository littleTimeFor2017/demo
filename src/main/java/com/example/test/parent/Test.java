package com.example.test.parent;

/**
 * @author Bruce Lee
 * @date 2021/6/11
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Child c = new Child();
    }

}


class Parent {
    public Parent() {
        System.out.println("this is parent constructure");
    }
}

class Child extends Parent {

    public Child() {
        System.out.println("this is child construct");
    }
}
