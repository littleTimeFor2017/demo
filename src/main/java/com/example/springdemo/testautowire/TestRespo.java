package com.example.springdemo.testautowire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestRespo {
    /**
     * Autowired 表示按照类型自动装配
     * 1>当容器中有多个相同类型的bean时，可以配合注解@Qualifier(value = "beanName")一起使用
     * 2>当Autowire标注的属性类型为集合或者map或者数组的时候，会将同一接口的所有实现类都注入进来
     */
    @Autowired
    private Map<String, TestLogInterface> interfaceMap;


    @Autowired
    private List<TestLogInterface> interfaces;

    //    @Autowired
    public TestRespo(Map<String, TestLogInterface> interfaceMap) {
        this.interfaceMap = interfaceMap;
    }

    public Map<String, TestLogInterface> getInterfaceMap() {
        return interfaceMap;
    }


    public List<TestLogInterface> getInterfaces() {
        return interfaces;
    }
}
