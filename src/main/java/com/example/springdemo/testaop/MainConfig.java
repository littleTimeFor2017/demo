package com.example.springdemo.testaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.springdemo.testaop"})
//@EnableAspectJAutoProxy(proxyTargetClass = true) 强制使用CGLIB动态代理
//@EnableAspectJAutoProxy(exposeProxy = true)  提前发布代理对象
public class MainConfig {

    @Bean
    public TestAspectJ testAspectJ() {
        return new TestAspectJ();
    }


}
