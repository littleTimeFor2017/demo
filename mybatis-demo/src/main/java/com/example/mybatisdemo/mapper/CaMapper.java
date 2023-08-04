package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.pojo.CA;

import java.util.List;

public interface CaMapper {


    List<CA> selectList();

   int insert(CA ca);

}
