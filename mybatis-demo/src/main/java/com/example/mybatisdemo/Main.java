package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.CaMapper;
import com.example.mybatisdemo.pojo.CA;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(new FileReader("/home/lixc/IdeaProjects/demo/mybatis-demo/src/main/resources/mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CaMapper mapper = sqlSession.getMapper(CaMapper.class);
        List<CA> cas = mapper.selectList();
        System.out.println(cas.size());
    }
}
