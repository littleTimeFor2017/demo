package com.example.springdemo.testjavaconfig;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/5
 * @Description:
 */
//@Configuration
//@ComponentScan(basePackageClasses ={TestDataSource.class} )
public class TestDataSourceConfig {


//    @Bean("dataSource")
//    public DataSource mysqlDataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setPassword(password);
//        dataSource.setDriverClassName(driver);
//        dataSource.setUsername(userName);
//        dataSource.setJdbcUrl(url);
//        return dataSource;
//    }


}
