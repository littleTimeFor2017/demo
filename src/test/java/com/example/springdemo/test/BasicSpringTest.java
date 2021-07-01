package com.example.springdemo.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.sql.rowset.spi.XmlReader;

/**
 * @className: BasicSpringTest
 * @description: TODO
 * @Author: Wilson
 * @createTime 2020/11/11 16:07
 */
public class BasicSpringTest {

    @Test
    public void simpleTest1() {
        //根据xml文件创建Resource对象，
        ClassPathResource classPathResource = new ClassPathResource("application-dev.xml");
        //创建beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建beanDefinitionReader读取器，用于载入beadDefinition
        //之所以需要传入参数beanFactory,是因为会将读取的信息回调给beanFactory
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        //执行bean的载入方法，完成bean的加载和注册
        //完成后 bean就成功的注册到了benaFactory,我们就可以从factory中获取了
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);

        //从beanFactory中获取bean
        Object test = beanFactory.getBean("test");
        //com.example.springdemo.test.TestBean@1e8b406
        System.out.println(test);


    }

    @Test
    public void simpleTest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-dev.xml");
        Object test1 = applicationContext.getBean("test");
        //com.example.springdemo.test.TestBean@14c4973
        System.out.println(test1);
    }
}
