package com.example.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/27
 * @Description: 编译期间和运行期间 结果测试
 * 1> test1 查看编译后的class文件，发现
 * int product1 = 30;
 * int product2 = number3 * number4;
 * 2> 包装类型与常用类型
 * 3>  Java里的泛型是在编译时构造的，可以通过查看编译后的class文件来理解泛型，也可以通过查看它来解决泛型相关的问题。
 * 4> 继承也是发生在编译期间的
 * 5> @Override注解 也是编译期间进行检查的
 */
public class BuildRunTest {


    public static final int number1 = 5;
    public static final int number2 = 6;
    public static int number3 = 5;
    public static int number4 = 6;

    @Test
    public void test1() {
        int product1 = number1 * number2;
        int product2 = number3 * number4;
    }

    @Test
    public void test2() {
        int a = 1;
        Integer number = 1;
        boolean flag = number == a;
    }

    /**
     * 这个是发生在编译时的。方法重载也被称为编译时多态，因为编译器可以根据参数的类型来选择使用哪个方法。
     */
    @Test
    public void test3() {
        A test1 = new A();
        //方法重载
        test1.test("123");
    }

    /**
     * 这个是在运行时发生的。方法重写称为运行时多态，因为在编译期编译器不知道并且没法知道该去调用哪个方法。JVM会在代码运行的时候做出决定。
     * 编译器是没法知道传入的参数reference的类型是A还是B。因此，只能够在运行时，根据赋给输入变量“reference”的对象的类型
     * （例如，A或者B的实例）来决定调用A还是B的方法.
     */
    @Test
    public void test4() {
        evaluate(new A(), 123);
    }


    /**
     * 泛型（又称类型检验）：这个是发生在编译期的。编译器负责检查程序中类型的正确性，
     * 然后把使用了泛型的代码翻译或者重写成可以执行在当前JVM上的非泛型代码。这个技术被称为“类型擦除“。
     * 换句话来说，编译器会擦除所有在尖括号里的类型信息，来保证和版本1.4.0或者更早版本的JRE的兼容性。
     * 编译完之后就会变成如下的结果
     * ---{
     * List myList = new ArrayList(10);
     * }
     */
    @Test
    public void test5() {
        List<String> myList = new ArrayList<>(10);
    }


    public void evaluate(A reference, int arg2) {
        reference.test(arg2);
    }

    class A {

        public void test(String param) {
            System.out.println("String");
        }

        public void test(int param) {
            System.out.println("int");
        }
    }

    class B extends A {
        @Override
        public void test(String param) {
            System.out.println(" child String");
        }

        @Override
        public void test(int param) {
            System.out.println(" child int");
        }
    }

}
