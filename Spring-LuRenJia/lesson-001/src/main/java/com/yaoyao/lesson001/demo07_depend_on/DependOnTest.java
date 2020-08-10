package com.yaoyao.lesson001.demo07_depend_on;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: DependOnTest
 * Description:
 * Date: 2020年08月08日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class DependOnTest {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

    /**
     * 无依赖的bean创建和销毁的顺序
     *
     * 通过该单元测试得出结论：
     *     bean对象的创建顺序和bean xml中定义的顺序一致
     *     bean销毁的顺序和bean xml中定义的顺序相反
     */
    @Test
    public void normalBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:com/yaoyao/lesson001/demo07_depend_on/normalBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        //关闭容器
        context.close();
        System.out.println("spring容器已关闭!");
    }

    /**
     * 强依赖的bean的创建和销毁顺序测试
     *
     * 通过该单元测试得出结论：
     *     bean对象的创建顺序和bean依赖的顺序一致
     *     bean销毁的顺序和bean创建的顺序相反
     */
    @Test
    public void strongDependenceBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:com/yaoyao/lesson001/demo07_depend_on/strongDependenceBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }

    /**
     * 通过depend-on来干预bean创建和销毁顺序
     */
    @Test
    public void dependOnBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:com/yaoyao/lesson001/demo07_depend_on/dependOnBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }

}
