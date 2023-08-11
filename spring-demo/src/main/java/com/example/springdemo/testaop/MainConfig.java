package com.example.springdemo.testaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.springdemo.testaop"})
//@EnableAspectJAutoProxy(proxyTargetClass = true) 强制使用CGLIB动态代理
//@EnableAspectJAutoProxy(exposeProxy = true)  提前发布代理对象,使用AopContext.getCurrentProxy()可以获取到当前的代理对象，使用this则不会进行代理
public class MainConfig {

    @Bean
    public TestAspectJ testAspectJ() {
        return new TestAspectJ();
    }


    @Bean
    public TestAspectJ2 testAspectJ2() {
        return new TestAspectJ2();
    }

}
