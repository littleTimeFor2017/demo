package com.example.springdemo.testbeanlifycycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean的后置处理器，会拦截所有的bean
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor...postProcessBeforeInitialization>>>>" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor...postProcessAfterInitialization>>>>" + beanName);
        return bean;
    }
}
