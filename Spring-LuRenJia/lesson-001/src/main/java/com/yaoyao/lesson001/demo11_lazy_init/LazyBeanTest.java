package com.yaoyao.lesson001.demo11_lazy_init;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: LazyBeanTest
 * Description:
 * Date: 2020年08月12日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class LazyBeanTest {

    /**
     * bean默认是实时初始化的
     */
    @Test
    public void actualTimeBean() {
        System.out.println("spring容器启动中...");
        String beanXml = "classpath:com/yaoyao/lesson001/demo11_lazy_init/actualTimeBean.xml";
        new ClassPathXmlApplicationContext(beanXml); //启动spring容器
        System.out.println("spring容器启动完毕...");
    }

    /**
     * 通过bean元素的lazy-init="true"将bean定义为延迟初始化
     */
    @Test
    public void lazyInitBean() {
        System.out.println("spring容器启动中...");
        String beanXml = "classpath:com/yaoyao/lesson001/demo11_lazy_init/lazyInitBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml); //启动spring容器
        System.out.println("spring容器启动完毕...");
        System.out.println("从容器中开始查找LazyInitBean");
        LazyInitBean lazyInitBean = context.getBean(LazyInitBean.class);
        System.out.println("LazyInitBean:" + lazyInitBean);
    }

    /**
     * 如果延迟初始化的bean被其他实时初始化的bean依赖，
     * 延迟初始化的bean也会在容器创建的时候进行初始化
     */
    @Test
    public void actualTimeDependencyLazyBean() {
        System.out.println("spring容器启动中...");
        String beanXml = "classpath:com/yaoyao/lesson001/demo11_lazy_init/actualTimeDependencyLazyBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml); //启动spring容器
        System.out.println("spring容器启动完毕...");
    }

}
