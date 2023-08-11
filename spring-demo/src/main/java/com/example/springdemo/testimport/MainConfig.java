package com.example.springdemo.testimport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.example.springdemo.testimport"})
@Import(value = {Person.class, Car.class, TestImportSelector.class, TestImportBeanDefinitionRegister.class})
public class MainConfig {

}
