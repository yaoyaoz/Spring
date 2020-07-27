package com.yaoyao.lesson001.demo05;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: DiTest
 * Description: 依赖注入测试类：1、构造函数注释；2、setter注入
 * Date: 2020年07月27日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class DiTest {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

    /**
     * 通过构造器的参数位置注入
     */
    @Test
    public void diByConstructorParamIndex() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diByConstructorParamIndex.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diByConstructorParamIndex"));
    }

    /**
     * 通过构造器的参数类型注入
     */
    @Test
    public void diByConstructorParamType() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diByConstructorParamType.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diByConstructorParamType"));
    }

    /**
     * 通过构造器的参数名称注入
     */
    @Test
    public void diByConstructorParamName() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diByConstructorParamName.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diByConstructorParamName"));
    }

    /**
     * 通过setter方法注入
     */
    @Test
    public void diBySetter() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diBySetter.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diBySetter"));
    }

    /**
     * 注入容器中的bean
     */
    @Test
    public void diBean(){
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diBeanByConstructor"));
        System.out.println(context.getBean("diBeanBySetter"));
    }

    /**
     * 其他各种类型注入
     */
    @Test
    public void diOtherType() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo05/diOtherType.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diOtherType"));
    }

}
