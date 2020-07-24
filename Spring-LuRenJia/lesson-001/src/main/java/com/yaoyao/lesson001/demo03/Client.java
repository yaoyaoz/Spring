package com.yaoyao.lesson001.demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: Client
 * Description:
 * Date: 2020年07月24日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class Client {
    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:com/yaoyao/lesson001/demo03/beans.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println("spring容器中所有bean如下：");

        //getBeanDefinitionNames用于获取容器中所有bean的名称
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }

        System.out.println("--------------------------");
        //多次获取createByFactoryBean看看是否是同一个对象
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));

    }
}