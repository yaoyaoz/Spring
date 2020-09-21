package com.yaoyao.lesson001.demo26_autowired;

import com.yaoyao.lesson001.demo26_autowired.test0.MainConfig0;
import com.yaoyao.lesson001.demo26_autowired.test1.MainConfig1;
import com.yaoyao.lesson001.demo26_autowired.test2.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: InjectTest
 * Description:
 * Date: 2020年08月20日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class InjectTest {

    /*
    案例1：@Autowired标注在构造器上，通过构造器注入依赖对象
     */
    @Test
    public void test0() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    /*
    案例2：@Autowired标注在方法上，通过方法注入依赖的对象
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

    /*
    案例3：@Autowired标注在setter方法上，通过setter方法注入
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }

}
