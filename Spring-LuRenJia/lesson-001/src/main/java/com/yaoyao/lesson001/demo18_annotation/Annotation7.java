package com.yaoyao.lesson001.demo18_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Annotation7
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target(value = {
        ElementType.TYPE_PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation7 {
    String value();
}
