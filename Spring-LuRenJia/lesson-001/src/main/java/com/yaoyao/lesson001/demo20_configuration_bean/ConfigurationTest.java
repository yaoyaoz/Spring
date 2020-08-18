package com.yaoyao.lesson001.demo20_configuration_bean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * ClassName: ConfigurationTest
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ConfigurationTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);//@1
        for (String beanName : context.getBeanDefinitionNames()) {
            //别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean1.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            //别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }

    /*
    被@Configuration修饰的类，spring容器中会通过cglib给这个类创建一个代理，
    代理会拦截所有被@Bean修饰的方法，默认情况（bean为单例）下确保这些方法只被调用一次，
    从而确保这些bean是同一个bean，即单例的。

    源码：org.springframework.context.annotation.ConfigurationClassPostProcessor
    postProcessBeanDefinitionRegistry
    postProcessBeanFactory
    enhanceConfigurationClasses：创建cglib代理
     */
    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            //别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName)));
        }
    }
}
