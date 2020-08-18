package com.yaoyao.lesson001.demo18_annotation;

import java.util.Map;

/**
 * ClassName: UseAnnotation8
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Annotation8("用在了类上")
public class UseAnnotation8<@Annotation8("用在了类变量类型V1上") V1, @Annotation8("用在了类变量类型V2上") V2> {
    private Map<@Annotation8("用在了泛型类型上") String, Integer> map;

    public <@Annotation8("用在了参数上") T> String m1(String name) {
        return null;
    }
}
