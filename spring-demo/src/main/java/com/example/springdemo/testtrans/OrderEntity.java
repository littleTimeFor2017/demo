package com.example.springdemo.testtrans;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/7
 * @Description:
 */
@Data
public class OrderEntity {

    private int id;
    private BigDecimal price;
    private int num;
}
