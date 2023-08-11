package com.example.springdemo.testtrans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/9
 * @Description:
 */
@Data
@Component
@PropertySource(value = "classpath:application-dev.properties")
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceEntity {

    private String url;
    private String driver;
    private String username;
    private String password;


    @Override
    public String toString() {
        return "TestDataSource{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
