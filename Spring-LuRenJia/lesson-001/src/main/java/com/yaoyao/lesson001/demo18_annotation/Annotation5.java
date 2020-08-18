package com.yaoyao.lesson001.demo18_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Annotation5
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation5 {
    String[] name() default {"路人甲java", "spring系列"};//@1
    int[] score() default 1; //@2
    int age() default 30; //@3
    String address(); //@4
}
