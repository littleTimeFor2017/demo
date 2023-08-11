package com.example.springdemo.testtrans;

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

        ((TestService) AopContext.currentProxy()).doSomething();  //利用aop的方式进行调用
//        this.doSomething(); //普通方式进行调用
        //外层方法
//        System.out.println(1 / 0);
        return String.valueOf(1);
    }

    /**
     * 内层的调用方法，测试传播属性
     */
    @Override

//    每次都重新开启一个新的事务
//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
//    如果当前存在事务，则加入当前事务中，如果当前不存在事务，则创建一个新的事务
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
//    支持当前事务，如果当前不存在事务，则会抛出一个异常
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.MANDATORY)
//     以非事务的方式运行，如果当前存在事务，则抛出一个异常，会导致两个方法都回滚
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NEVER)
//    嵌套事务，感觉跟requires_new类似
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    /**
     * 以非事务方式执行，如果存在当前事务，则挂起当前事务，
     * 1.如果当前方法在写之后抛出异常，则当前方法写成功，外层方法带有事务调用回滚
     * 1.如果当前方法在写之前抛出异常，则当前方法写回滚，外层方法带有事务调用回滚
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    //支持当前事务，如果不存在则以非事务方式执行。
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.SUPPORTS)

    public void doSomething() {
        OrderEntity entity = new OrderEntity();
        entity.setNum(100);
        entity.setPrice(new BigDecimal("100.00"));
        System.out.println(1 / 0);
        testMapper.saveUser(entity);
        System.out.println("doSomething over");

    }

}
