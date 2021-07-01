package com.example.lumbdademo.test;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.function.*;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/15
 * @Description: 所有标注了FunctionalInterface的接口都是方法接口，new 这个接口的时候就要给出具体的实现(s)-> System.out.println(s)
 */
public class TestLumbda {
    /**
     * 一般方法的方法接口，
     * Function 带有返回结果的接口方法，抽象方法为apply，接受一个参数
     * BiFunction  带有返回结果的接口方法，抽象方法为apply，接收两个参数
     */
    @Test
    public void testNormalFunction() {
        //带有一个参数的  有返回结果的方法接口Function<String(入参), Integer(返回结果类型)>
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("123");
        System.out.println("带有一个入参，一个返回参数的方法接口function:" + apply);


        //带有两个入参，一个返回参数
        // 如果有多行的话，需要显示的声明return
        // 如果只有一行， 默认返回表达式的结果
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> {
            System.out.println("a" + a);
            return a + b;
        };

        Integer apply1 = biFunction.apply(1, 2);
        System.out.println("带有两个入参，一个返回参数的方法接口biFunction:" + apply1);
    }

    /**
     * 输入输出为同一类型的方法接口，继承自Function  抽象方法为apply
     * UnaryOperator 需要一个参数，BinaryOperator需要两个参数
     * 不用手动return，直接接受方法返回参数即可
     */
    @Test
    public void testUnaryOperator() {
        UnaryOperator<Boolean> unaryOperator = (s) -> true == s;
        Boolean apply = unaryOperator.apply(false);
        System.out.println(apply);

        UnaryOperator<String> unaryOperator1 = (s) -> s.toUpperCase();
        System.out.println(unaryOperator1.apply("this is my lower case"));


        BinaryOperator<String> binaryOperator = (a, b) -> a + b.toUpperCase();
        System.out.println(binaryOperator.apply("1", "a"));
    }

    /**
     * 返回结果为boolean类型的方法接口  抽象方法为test  输出结果为boolean类型
     * Predicate 接受一个参数  BiPredicate 接收两个参数
     */
    @Test
    public void testPredicate() {
        Predicate<String> predicate = (s) -> s.equalsIgnoreCase("123");
        System.out.println(predicate.test("12w3"));

        BiPredicate<String, String> bipredicate = (a, b) -> a.equalsIgnoreCase(b);
        System.out.println(bipredicate.test("a", "A"));
    }


    /**
     * 无返回结果的接口方法，抽象方法为accept，
     * Consumer接收一个参数
     */
    @Test
    public void testConsumer() {
        Consumer<String> consumerOld = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumerOld.accept("consumerOld");


        //带有一个参数的无返回的结果的方法接口Consumer<String(参数类型)>
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("带有一个参数的无返回的结果的方法接口Consume:123");

        //带有两个参数的无返回的结果的方法接口Consumer<String(参数类型)>
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept("1", "2");

        //方法引用
        //函数式接口的实现恰好可以通过调用一个方法来实现，那么我们可以使用方法引用
        //这个接口的实现 只调用了一个println方法，所有我们可以使用方法引用来代替
//        Consumer<String> consumer3 = s -> System.out.println(s);
//        consumer3.accept("方法实现");
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("方法引用实现");
    }

    /**
     * 没有参数，只有返回值， Supplier<String>String 表示返回值的类型
     */
    @Test
    public void testSupplier() {
        Supplier<String> stringSupplier = () -> "123";
        System.out.println(stringSupplier.get());
    }
}
