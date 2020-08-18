package com.yaoyao.lesson001.demo18_annotation;

import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: UseAnnotation15
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface A15 {
    @AliasFor("v2")//@1
            String v1() default "";

    @AliasFor("v1")//@2
            String v2() default "";
}

@A15(v1 = "我是v1")
public class UseAnnotation15 {
    @A15(v2 = "我是v2") //@4
    private String name;

    @Test
    public void test1() throws NoSuchFieldException {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation15.class, A15.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation15.class.getDeclaredField("name"), A15.class));
    }
}
