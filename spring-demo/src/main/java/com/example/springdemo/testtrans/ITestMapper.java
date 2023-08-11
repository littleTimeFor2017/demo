package com.example.springdemo.testtrans;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/7
 * @Description:
 */
@Mapper
//@CacheNamespace
public interface ITestMapper {
    int query();

    int saveUser(OrderEntity orderEntity);
}
