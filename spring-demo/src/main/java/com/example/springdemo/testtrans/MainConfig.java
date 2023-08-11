package com.example.springdemo.testtrans;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @Author: Bruce Lee
 * @Date: 2020/12/4
 * @Description:
 */
@ComponentScan(basePackages = {"com.example.springdemo.testtrans"})
@EnableConfigurationProperties
@EnableAspectJAutoProxy(exposeProxy = true)
//@Import(value = {MainConfig1.class})

@EnableTransactionManagement()
public class MainConfig implements InitializingBean {

    @Autowired
    private DataSourceEntity dataSourceEntity;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSourceEntity.getUrl());
        dataSource.setUsername(dataSourceEntity.getUsername());
        dataSource.setDriverClassName(dataSourceEntity.getDriver());
        dataSource.setPassword(dataSourceEntity.getPassword());
        return dataSource;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
