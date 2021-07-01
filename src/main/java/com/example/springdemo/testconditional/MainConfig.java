package com.example.springdemo.testconditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Conditional 可以用在类  也可以用在方法上,当类A依赖于B时，可以使用此条件判断，
 * 如果当前环境中没有B，则不加载A
 */
@Configuration
public class MainConfig {

    //    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    //TestCondition返回一个boolean类型，如果为true，则初始化Cat1
    @Conditional(TestCondition.class)
    public Cat1 cat1() {
        return new Cat1();
    }

}
