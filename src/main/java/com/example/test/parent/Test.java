package com.example.test.parent;

/**
 * @author Bruce Lee
 * @date 2021/6/11
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        Child1 child1 = new Child1();
        c.say();
    }

}


abstract class Parent {

    protected void say() {
        System.out.println("parent say");
    }

    /**
     * say1
     */
    abstract void say1();
}

class Child1 extends Parent {
    @Override
    public void say1() {
        super.say();
        System.out.println("Child1 say");
    }
}

class Child extends Parent {

    public Child() {
        System.out.println("this is child construct");
    }

    @Override
    void say1() {

    }
}
