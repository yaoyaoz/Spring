package com.yaoyao.lesson001.demo18_annotation;

import java.lang.annotation.*;

/**
 * ClassName: InheritAnnotationTest
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class InheritAnnotationTest {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A1{ //@1
    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A2{ //@2
    }

    @A1 //@3
    interface I1{}
    @A2 //@4
    static class C1{}

    static class C2 extends C1 implements I1{} //@5

    /*
    从输出中可以看出类可以继承父类上被@Inherited修饰的注解，而不能继承接口上被@Inherited修饰的注解，这个一定要注意
     */
    public static void main(String[] args) {
        for (Annotation annotation : C2.class.getAnnotations()) { //@6
            System.out.println(annotation);
        }
    }
}
