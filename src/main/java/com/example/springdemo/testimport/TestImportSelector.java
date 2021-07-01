package com.example.springdemo.testimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //此处为类的完全限定名
        return new String[]{"com.example.springdemo.testimport.Dog"};
    }
}
