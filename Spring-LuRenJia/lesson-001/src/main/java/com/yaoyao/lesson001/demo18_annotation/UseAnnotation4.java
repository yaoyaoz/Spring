package com.yaoyao.lesson001.demo18_annotation;

/**
 * ClassName: UseAnnotation4
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Annotation4(name = {"我是路人甲java", "欢迎和我一起学spring"})
public class UseAnnotation4 {
    @Annotation4(name = "如果只有一个值，{}可以省略") //@3
    public class T1 {
    }
}
