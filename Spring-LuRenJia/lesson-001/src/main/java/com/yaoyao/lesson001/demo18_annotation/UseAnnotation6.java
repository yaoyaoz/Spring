package com.yaoyao.lesson001.demo18_annotation;

import java.lang.annotation.ElementType;

/**
 * ClassName: UseAnnotation6
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Annotation6(value = "我用在类上", elementType = ElementType.TYPE)
public class UseAnnotation6 {
    @Annotation6(value = "我用在字段上", elementType = ElementType.FIELD)
    private String a;

    @Annotation6(value = "我用在构造方法上", elementType = ElementType.CONSTRUCTOR)
    public UseAnnotation6(@Annotation6(value = "我用在方法参数上", elementType = ElementType.PARAMETER) String a) {
        this.a = a;
    }

    @Annotation6(value = "我用在了普通方法上面", elementType = ElementType.METHOD)
    public void m1() {
        @Annotation6(value = "我用在了本地变量上", elementType = ElementType.LOCAL_VARIABLE) String a;
    }
}
