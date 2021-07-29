package com.example.springdemo.testtrans;

import org.aspectj.weaver.ast.Or;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String query() {
        OrderEntity entity = new OrderEntity();
        entity.setNum(200);
        entity.setPrice(new BigDecimal("200.00"));
        testMapper.saveUser(entity);
        ((TestService) AopContext.currentProxy()).doSomething();
//        doSomething();
        System.out.println(1/0);
        return String.valueOf(1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void doSomething() {
        OrderEntity entity = new OrderEntity();
        entity.setNum(100);
        entity.setPrice(new BigDecimal("100.00"));
        testMapper.saveUser(entity);
        System.out.println("doSomething over");
    }
}
