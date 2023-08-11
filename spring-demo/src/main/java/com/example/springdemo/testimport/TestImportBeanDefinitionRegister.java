package com.example.springdemo.testimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:17
 * @Description: 可以自定义bean的名称
 */
public class TestImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(AA.class);
        registry.registerBeanDefinition("aa", rootBeanDefinition);
    }
}
