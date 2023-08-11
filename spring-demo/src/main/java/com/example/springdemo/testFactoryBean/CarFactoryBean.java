package com.example.springdemo.testFactoryBean;

import com.example.springdemo.testimport.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: Bruce Lee
 * @Date: 2020/11/25 14:21
 * @Description:
 */
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
