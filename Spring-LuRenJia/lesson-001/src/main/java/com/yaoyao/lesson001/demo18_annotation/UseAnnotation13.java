package com.yaoyao.lesson001.demo18_annotation;

import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: UseAnnotation13
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface A1 {
    String value() default "a";//@0
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@A1
@interface B1 { //@1
    String value() default "b";//@2
}

@B1("路人甲Java")
public class UseAnnotation13 {
    @Test
    public void test1() {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation13.class, B1.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation13.class, A1.class));
    }
}
