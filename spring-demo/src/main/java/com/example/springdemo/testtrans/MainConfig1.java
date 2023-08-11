package com.example.springdemo.testtrans;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/10
 * @Description:
 */
public class MainConfig1 implements ImportAware {

    private Set<String> strSet;

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        Set<String> annotationTypes = importMetadata.getAnnotationTypes();
//
        strSet = annotationTypes;
    }

    public Set<String> getStrSet() {
        for (String str : strSet) {
            System.out.println(str);
        }
        return strSet;
    }

    @Override
    public String toString() {
        return "MainConfig1{" +
                "strSet=" + strSet +
                '}';
    }
}
