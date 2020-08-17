package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: ReplacedMethodTest
 * Description:
 * Date: 2020年08月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ReplacedMethodTest {

    /**
     * 从输出中可以看出结果和lookup-method案例效果差不多，实现了单例bean中使用多例bean的案例。
     * 输出中都有CGLIB这样的字样，说明这玩意也是通过cglib实现的。
     */
    @Test
    public void replacedmethod() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo13_lookupmethod_replacedmethod/replacedmethod.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }
}
