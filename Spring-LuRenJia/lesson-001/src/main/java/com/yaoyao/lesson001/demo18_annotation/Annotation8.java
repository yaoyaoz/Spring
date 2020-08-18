package com.yaoyao.lesson001.demo18_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Annotation8
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target({ElementType.TYPE_USE})//这个是1.8加上的，能用在任何类型名称上
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation8 {
    String value();
}
