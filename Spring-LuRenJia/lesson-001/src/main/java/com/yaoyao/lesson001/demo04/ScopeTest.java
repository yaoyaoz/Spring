package com.yaoyao.lesson001.demo04;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: ScopeTest
 * Description:
 * Date: 2020年07月24日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ScopeTest {
    ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        System.out.println("spring容器准备启动.....");
        //1.bean配置文件位置
        String beanXml = "classpath:com/yaoyao/lesson001/demo04/beans.xml";
        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        this.context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("spring容器启动完毕！");
    }

    /**
     * 单例bean
     */
    @Test
    public void singletonBean() {
        System.out.println("---------单例bean，每次获取的bean实例都一样---------");
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
    }

    /**
     * 多例bean
     */
    @Test
    public void prototypeBean() {
        System.out.println("---------多例bean，每次获取的bean实例都不一样---------");
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
    }

}