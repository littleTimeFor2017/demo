package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.CaMapper;
import com.example.mybatisdemo.pojo.CA;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CaMapper mapper = sqlSession.getMapper(CaMapper.class);
        int i = mapper.insert(new CA("lixc"));
        System.out.println(i);
//        sqlSession.commit();
        List<CA> cas = mapper.selectList();
        System.out.println(cas.size());
    }
}
