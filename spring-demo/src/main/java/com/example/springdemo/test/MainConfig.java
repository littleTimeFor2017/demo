package com.example.springdemo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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

    /**
     * initMethod属性表示的是要创建的bean的内部的方法。
     *
     * @return
     */
    @Bean(initMethod = "PostConstruct")
    public TestBean testBean() {
        return new TestBean("abx");
    }
}
