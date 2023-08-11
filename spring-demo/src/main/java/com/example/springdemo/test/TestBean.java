package com.example.springdemo.test;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @className: TestBean
 * @description: TODO
 * @Author: Wilson
 * @createTime 2020/11/11 16:53
 */
//@Component
@Data
public class TestBean implements InitializingBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
        System.out.println("这是构造方法");
    }

    @PostConstruct
    public void PostConstruct() {
        System.out.println("这是PostConstruct注解标注的方法");
    }

    private String value = getValue();

    private String getValue() {
        System.out.println("填充属性方法");
        return "这是填充属性方法";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("这是afterPropertiesSet方法");
    }


    //    @Value("lixc")
//    private String name;
//
//    @Value("#{20+8}")
//    private int age;
//
//
//    @Value("${user.addr}")
//    private String addr;
//
//
//    @Override
//    public String toString() {
//        return "TestBean{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
}
