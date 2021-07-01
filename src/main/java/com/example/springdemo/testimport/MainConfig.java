package com.example.springdemo.testimport;

import com.example.springdemo.testbeanlifycycle.Book;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages = {"com.example.springdemo.testimport"})
@Import(value = {Person.class, Car.class, TestImportSelector.class, TestImportBeanDefinitionRegister.class})
public class MainConfig {

}
