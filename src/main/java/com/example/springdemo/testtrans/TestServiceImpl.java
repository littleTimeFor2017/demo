package com.example.springdemo.testtrans;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/5
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private ITestMapper testMapper;

    @Transactional
    public String query() {
        //数据库查询
//        System.out.println(1 / 0);
        OrderEntity entity = new OrderEntity();
        entity.setNum(200);
        entity.setPrice(new BigDecimal("200.00"));
        testMapper.saveUser(entity);
//        System.out.println(1 / 0);
        doSomething();
        return String.valueOf(1);
    }

    //    @Transactional
    public void doSomething() {
//        System.out.println(1 / 0);
        OrderEntity entity = new OrderEntity();
        entity.setNum(100);
        entity.setPrice(new BigDecimal("100.00"));
        testMapper.saveUser(entity);
    }
}
