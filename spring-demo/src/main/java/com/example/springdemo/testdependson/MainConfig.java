package com.example.springdemo.testdependson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class MainConfig {

    @Bean()
    @DependsOn(value = "instanceB")
    public InstanceA instanceA() {
        return new InstanceA();
    }

    @Bean()
    public InstanceB instanceB() {
        return new InstanceB();
    }
}
