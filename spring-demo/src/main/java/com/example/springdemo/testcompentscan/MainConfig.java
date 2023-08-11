package com.example.springdemo.testcompentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = {"com.example.springdemo.testcompentscan"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = TestFilter.class)
        },
        //如果使用默认的过滤器，则自定义的过滤器不会生效
        useDefaultFilters = false)
//@ComponentScan(
//        basePackages = {"com.example.springdemo.testcompentscan"},
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
//        })
public class MainConfig {
}
