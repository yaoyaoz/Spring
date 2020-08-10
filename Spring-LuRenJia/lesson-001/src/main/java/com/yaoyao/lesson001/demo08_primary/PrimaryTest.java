package com.yaoyao.lesson001.demo08_primary;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: PrimaryTest
 * Description:
 * Date: 2020年08月10日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class PrimaryTest {
    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

    /**
     * 发生异常了：
     * No qualifying bean of type 'com.yaoyao.lesson001.demo08_primary.NormalBean$IService' available: expected single matching bean but found 2: serviceA,serviceB
     */
    @Test
    public void normalBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo08_primary/normalBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        //下面我们通过spring容器的T getBean(Class<T> requiredType)方法获取容器中对应的bean
        NormalBean.IService service = context.getBean(NormalBean.IService.class); //@1
        System.out.println(service);
    }

    /**
     * 也发生异常了：
     * No qualifying bean of type 'com.yaoyao.lesson001.demo08_primary.SetterBean$IService' available: expected single matching bean but found 2: serviceA,serviceB
     */
    @Test
    public void setterBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo08_primary/setterBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
    }

    @Test
    public void primaryBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo08_primary/primaryBean.xml";
        ClassPathXmlApplicationContext context = context(beanXml);
        PrimaryBean.IService service = context.getBean(PrimaryBean.IService.class); //@1
        System.out.println(service);
        PrimaryBean primaryBean = context.getBean(PrimaryBean.class); //@2
        System.out.println(primaryBean);
    }

}
