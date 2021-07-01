package com.example.springdemo.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/17
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void test() {
        long key_long = 4;
        int key_int = 4;
        double key_double = 4.0;
        Long key_Long = 4L;
        Integer key_Integer = 4;
        System.out.println("long = int " + (key_int == key_long));
        System.out.println("long = double " + (key_long == key_double));
        System.out.println("long = Integer " + (key_long == key_Integer));
        System.out.println("Long = int " + (key_Long == key_int));
        //Long = Integer 编译报错
//        System.out.println("Long = Integer " + (key_Long == key_Integer));

        User user = new User(key_Long);
        System.out.println(user.getId() == key_int);

        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe o = (Unsafe) field.get(null);
            o.fullFence();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    class User {
        private Long id;

        public User(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
