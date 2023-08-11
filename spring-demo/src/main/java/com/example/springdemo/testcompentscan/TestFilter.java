package com.example.springdemo.testcompentscan;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class TestFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取注解元信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息
        metadataReader.getResource();
        System.out.println("===================" + classMetadata.getClassName());
        if (classMetadata.getClassName().contains("Dao")) {
            return true;
        }
        return false;
    }
}
