package com.yaoyao.lesson001.demo22_componentScan;

import com.yaoyao.lesson001.demo22_componentScan.test1.ScanBean1;
import com.yaoyao.lesson001.demo22_componentScan.test2.ScanBean2;
import com.yaoyao.lesson001.demo22_componentScan.test3.ScanBean3;
import com.yaoyao.lesson001.demo22_componentScan.test6.ScanBean6;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: ComponentScanTest
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ComponentScanTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean3.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean6.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }
}
