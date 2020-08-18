package com.yaoyao.lesson001.demo18_annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * ClassName: UseAnnotation12
 * Description: @Repeatable重复使用注解
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@interface Ann12s {
    Ann12[] value(); //@1
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(Ann12s.class)//@2
@interface Ann12 {
    String name();
}

@Ann12(name = "路人甲Java")
@Ann12(name = "Spring系列")
public class UseAnnotation12 {
    @Ann12s(
            {@Ann12(name = "Java高并发系列，见公众号"),
                    @Ann12(name = "mysql高手系列，见公众号")}
    )
    private String v1;


    @Test
    public void test1() throws NoSuchFieldException {
        Annotation[] annotations = UseAnnotation12.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("-------------");
        Field v1 = UseAnnotation12.class.getDeclaredField("v1");
        Annotation[] declaredAnnotations = v1.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }
}
