package com.example.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Component;

@Component
public class RootBEanDefinitionTest {


    public static final String CONFIGURATION_CLASS_ATTRIBUTE =
            Conventions.getQualifiedAttributeName(ConfigurationClassPostProcessor.class, "configurationClass");

    public static void main(String[] args) {
        //定义ScopeMetadataResolver
        ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
        //RootBeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition(RootBEanDefinitionTest.class);
        System.out.println(beanDefinition.toString());
        //annotatedGenericBeanDefinition
        AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(RootBEanDefinitionTest.class);
        System.out.println(annotatedGenericBeanDefinition.toString());
        //scopeMetadata
        ScopeMetadata scopeMetadata = scopeMetadataResolver.resolveScopeMetadata(annotatedGenericBeanDefinition);
        System.out.println(scopeMetadata.toString());
        //metaData
        System.out.println(annotatedGenericBeanDefinition.getMetadata().toString());
        //
        System.out.println(Conventions.getQualifiedAttributeName(ConfigurationClassPostProcessor.class, "configurationClass"));
    }

    @Test
    public void testGetQualifiedAttributeName(){
        System.out.println(CONFIGURATION_CLASS_ATTRIBUTE);
    }


}
