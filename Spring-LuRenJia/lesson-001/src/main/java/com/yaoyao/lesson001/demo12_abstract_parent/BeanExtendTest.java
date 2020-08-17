package com.yaoyao.lesson001.demo12_abstract_parent;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: BeanExtendTest
 * Description: bean定义继承案例
 * Date: 2020年08月12日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class BeanExtendTest {

    @Test
    public void normalBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo12_parent/beanExtend.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("serviceB:" + context.getBean(ServiceB.class));
        System.out.println("serviceC:" + context.getBean(ServiceC.class));
    }

    /**
     * abstract、parent
     */
    @Test
    public void extendBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo12_abstract_parent/beanExtendAbstractParent.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("serviceB:" + context.getBean(ServiceB.class));
        System.out.println("serviceC:" + context.getBean(ServiceC.class));

        //这句会报错：因为baseService是抽象的，不能够创建这个bean实例。
        System.out.println(context.getBean("baseService"));
    }

}
