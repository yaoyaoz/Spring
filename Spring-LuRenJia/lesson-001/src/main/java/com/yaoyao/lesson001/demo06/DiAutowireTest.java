package com.yaoyao.lesson001.demo06;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: DiAutowireTest
 * Description:
 * Date: 2020年07月31日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class DiAutowireTest {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

    /**
     * Class.isAssignableFrom方法：
     * c1.isAssignableFrom(c2)
     * 用来判断c2和c1是否相等，或者c2是否是c1的子类。
     */
    @Test
    public void isAssignableFrom() {
        System.out.println(Object.class.isAssignableFrom(Integer.class)); //true
        System.out.println(Integer.class.isAssignableFrom(Object.class)); //false
        System.out.println(Object.class.isAssignableFrom(int.class)); //false
        System.out.println(Object.class.isAssignableFrom(List.class)); //true
        System.out.println(Collection.class.isAssignableFrom(List.class)); //true
        System.out.println(List.class.isAssignableFrom(Collection.class)); //false
    }

    /**
     * 按照名称进行注入
     */
    @Test
    public void diAutowireByName() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo06/diAutowireByName.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println("\ndiAutowireByName1:===================");
        System.out.println(context.getBean("diAutowireByName1"));
        System.out.println("\ndiAutowireByName2:===================");
        System.out.println(context.getBean("diAutowireByName2"));
    }

    /**
     * 按照set方法参数类型进行注入
     */
    @Test
    public void diAutowireByType() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo06/diAutowireByType.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println("【diAutowireByType1】：" + context.getBean("diAutowireByType1"));
    }

    /**
     * 按照类型注入集合
     */
    @Test
    public void diAutowireByTypeExtend() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo06/diAutowireByTypeExtend.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        //从容器中获取DiAutowireByTypeExtend
        DiAutowireByTypeExtend diAutowireByTypeExtend = context.getBean(DiAutowireByTypeExtend.class);
        System.out.println("【diAutowireByTypeExtend】：" + diAutowireByTypeExtend);
        //输出diAutowireByTypeExtend中的属性看一下
        System.out.println("【serviceList】：" + diAutowireByTypeExtend.getServiceList());
        System.out.println("【baseServieList】：" + diAutowireByTypeExtend.getBaseServieList());
        System.out.println("【service1Map】：" + diAutowireByTypeExtend.getService1Map());
        System.out.println("【baseServieMap】：" + diAutowireByTypeExtend.getBaseServieMap());
    }

    /**
     * 构造函数的方式进行自动注入
     */
    @Test
    public void diAutowireByConstructor() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo06/diAutowireByConstructor.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diAutowireByConstructor"));
    }

    /**
     * autowire=default
     */
    @Test
    public void diAutowireByDefault() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo06/diAutowireByDefault.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println(context.getBean("diAutowireByDefault1"));
        System.out.println(context.getBean("diAutowireByDefault2"));
    }

}
