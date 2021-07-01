package com.example.springdemo.testtrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/9
 * @Description:
 */
@Component
public class TestMapperImpl implements ITestMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int query() {
        String sql = "select num from `test_order` where id = 1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int saveUser(OrderEntity orderEntity) {
        String sql = " insert into test_order(price,num) values (?,?)";
        return jdbcTemplate.update(sql, orderEntity.getPrice(), orderEntity.getNum());
    }
}
