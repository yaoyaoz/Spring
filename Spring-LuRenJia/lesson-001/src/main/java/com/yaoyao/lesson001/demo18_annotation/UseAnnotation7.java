package com.yaoyao.lesson001.demo18_annotation;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * ClassName: UseAnnotation7
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class UseAnnotation7<@Annotation7("T0是在类上声明的一个泛型类型变量") T0, @Annotation7("T1是在类上声明的一个泛型类型变量") T1> {

    public <@Annotation7("T2是在方法上声明的泛型类型变量") T2> void m1() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        for (TypeVariable typeVariable : UseAnnotation7.class.getTypeParameters()) {
            print(typeVariable);
        }

        for (TypeVariable typeVariable : UseAnnotation7.class.getDeclaredMethod("m1").getTypeParameters()) {
            print(typeVariable);
        }
    }

    private static void print(TypeVariable typeVariable) {
        System.out.println("类型变量名称:" + typeVariable.getName());
        Arrays.stream(typeVariable.getAnnotations()).forEach(System.out::println);
    }

}
