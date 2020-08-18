package com.yaoyao.lesson001.demo18_annotation;

import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: UseAnnotation14
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface A14 {
    String value() default "a";//@0
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@A14 //@6
@interface B14 { //@1

    String value() default "b";//@2

    @AliasFor(annotation = A14.class, value = "value") //@5
    String a14Value();
}

@B14(value = "路人甲Java",a14Value = "通过B14给A14的value参数赋值")
public class UseAnnotation14 {
    @Test
    public void test1() {
        //AnnotatedElementUtils是spring提供的一个查找注解的工具类
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation14.class, B14.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(UseAnnotation14.class, A14.class));
    }
}
