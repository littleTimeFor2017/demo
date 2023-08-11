package com.example.springdemo.testjavaconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/9
 * @Description:
 */
@Configuration
@ComponentScan(basePackageClasses = {TestDataSource.class})
//必须开启注解以后才能使用@ConfigurationProperties
@EnableConfigurationProperties
public class TestDataSourceMainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestDataSourceMainClass.class);
        TestDataSource testDataSource = (TestDataSource) configApplicationContext.getBean("testDataSource");
        System.out.println(testDataSource.toString());
    }
}
