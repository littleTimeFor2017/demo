package com.example.springdemo.test;

import org.springframework.context.annotation.*;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:40
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = {"com.example.springdemo.test"})
@Import(TestService.class)
//@PropertySource(value = "classpath:application.yml")
public class MainConfig {

//    @Bean
//    public TestBean testBean() {
//        return new TestBean("abx");
//    }
}
