package com.example.test.datasource;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruce Lee
 * @date 2021/7/20
 * @description 数据源配置类
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource01(){
        MysqlDataSource  dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&nullNamePatternMatchesAll=true&autoReconnect=true&serverTimezone=GMT%2B8");
        return dataSource;
    }

    @Bean
    public TestDataSource dataSource() {
        TestDataSource testDataSource = new TestDataSource();
        Map<Object, Object> targetDataSource = new HashMap();
        targetDataSource.put("dataSource01",dataSource01());
        testDataSource.setTargetDataSources(targetDataSource);
        testDataSource.setDefaultTargetDataSource(dataSource01());
        return testDataSource;
    }
}
