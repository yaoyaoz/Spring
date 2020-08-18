package com.yaoyao.lesson001.demo18_annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Map;

/**
 * ClassName: UseAnnotation9
 * Description: 注解信息的获取
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Target({ElementType.PACKAGE,
        ElementType.TYPE,
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface Ann11 {
    String value();
}

@Target({ElementType.PACKAGE,
        ElementType.TYPE,
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface Ann11_0 {
    int value();
}

@Ann11("用在了类上")
@Ann11_0(0)
public class UseAnnotation11<@Ann11("用在了类变量类型V1上") @Ann11_0(1) V1, @Ann11("用在了类变量类型V2上") @Ann11_0(2) V2> {
    @Ann11("用在了字段上")
    @Ann11_0(3)
    private String name;

    private Map<@Ann11("用在了泛型类型上,String") @Ann11_0(4) String, @Ann11("用在了泛型类型上,Integer") @Ann11_0(5) Integer> map;

    @Ann11("用在了构造方法上")
    @Ann11_0(6)
    public UseAnnotation11() {
        this.name = name;
    }

    @Ann11("用在了返回值上")
    @Ann11_0(7)
    public String m1(@Ann11("用在了参数上") @Ann11_0(8) String name) {
        return null;
    }

    /*
    解析类上的注解
     */
    @Test
    public void m1() {
        for (Annotation annotation : UseAnnotation11.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    /*
    解析类上的类型变量
     */
    @Test
    public void m2() {
        TypeVariable<Class<UseAnnotation11>>[] typeParameters = UseAnnotation11.class.getTypeParameters();
        for (TypeVariable<Class<UseAnnotation11>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName() + "变量类型注解信息：");
            Annotation[] annotations = typeParameter.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }

    /*
    解析字段name上的注解
     */
    @Test
    public void m3() throws NoSuchFieldException {
        Field nameField = UseAnnotation11.class.getDeclaredField("name");
        for (Annotation annotation : nameField.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    /*
    解析泛型字段map上的注解
     */
    @Test
    public void m4() throws NoSuchFieldException, ClassNotFoundException {
        Field field = UseAnnotation11.class.getDeclaredField("map");
        Type genericType = field.getGenericType();
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();

        AnnotatedType annotatedType = field.getAnnotatedType();
        AnnotatedType[] annotatedActualTypeArguments = ((AnnotatedParameterizedType) annotatedType).getAnnotatedActualTypeArguments();
        int i = 0;
        for (AnnotatedType actualTypeArgument : annotatedActualTypeArguments) {
            Type actualTypeArgument1 = actualTypeArguments[i++];
            System.out.println(actualTypeArgument1.getTypeName() + "类型上的注解如下：");
            for (Annotation annotation : actualTypeArgument.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

    /*
    解析构造函数上的注解
     */
    @Test
    public void m5() {
        Constructor<?> constructor = UseAnnotation11.class.getConstructors()[0];
        for (Annotation annotation : constructor.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    /*
    解析m1方法上的注解
     */
    @Test
    public void m6() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Annotation annotation : method.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    /*
    解析m1方法参数注解
     */
    @Test
    public void m7() throws NoSuchMethodException {
        Method method = UseAnnotation11.class.getMethod("m1", String.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(String.format("参数%s上的注解如下:", parameter.getName()));
            for (Annotation annotation : parameter.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

}
