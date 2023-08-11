package com.example.springdemo.testbeanlifycycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.springdemo.testbeanlifycycle"})
public class MainConfig {

    @Bean
    //@Scope(value="prototype")
    public Book book() {
        return new Book();
    }
}
