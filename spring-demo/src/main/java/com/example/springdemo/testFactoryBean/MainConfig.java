package com.example.springdemo.testFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:23
 * @Description:
 */
@Configuration
public class MainConfig {

    @Bean(value = "carFactory")
    public CarFactoryBean carFactoryBean() {
        return new CarFactoryBean();
    }
}
