package com.example.springdemo.testautowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 15:07
 * @Description:
 */
@Configuration
public class MainConfig {
    @Bean()
    public TestService testService() {
        return new TestService(1);
    }

    @Bean
    public TestService testService1() {
        return new TestService(2);
    }

    @Bean
    public TestController testController() {
        return new TestController();
    }


}
