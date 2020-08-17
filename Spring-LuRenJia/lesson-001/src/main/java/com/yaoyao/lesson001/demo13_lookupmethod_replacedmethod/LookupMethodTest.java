package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: LookupMethodTest
 * Description:
 * Date: 2020年08月12日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class LookupMethodTest {

    /**
     * 单例serviceB中获取的serviceA也是单例，尽管serviceA配置的是多例
     */
    @Test
    public void normalBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo13_lookupmethod_replacedmethod/normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        System.out.println(serviceB.getServiceA()); //@4
        System.out.println(serviceB.getServiceA()); //@5
    }

    /**
     * 因为单例serviceAwareB（实现了ApplicationContextAware）中的多例serviceA每次都是从容器里面去取的，
     * 所以从serviceAwareB获取的serviceA也是多例的
     */
    @Test
    public void alicationcontextaware() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo13_lookupmethod_replacedmethod/alicationcontextaware.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceAwareB中的serviceA");
        ServiceAwareB serviceB = context.getBean(ServiceAwareB.class); //@3
        serviceB.say();
        serviceB.say();
    }

    /**
     * lookup-method：解决单例bean中用到多例bean的问题
     */
    @Test
    public void lookupmethod() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo13_lookupmethod_replacedmethod/lookupmethod.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceLookupB中的serviceA");
        ServiceLookupB serviceLookupB = context.getBean(ServiceLookupB.class); //@3
        serviceLookupB.say();
        serviceLookupB.say();
    }

}
