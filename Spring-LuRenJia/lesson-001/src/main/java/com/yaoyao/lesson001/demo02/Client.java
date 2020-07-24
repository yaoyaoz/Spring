package com.yaoyao.lesson001.demo02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * ClassName: Client
 * Description:
 * Date: 2020年07月23日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class Client {
    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:com/yaoyao/lesson001/demo02/beans.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        for (String beanName : Arrays.asList("user1", "user2", "user3", "user4", "user5")) {
            //获取bean的别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
        }

        System.out.println("spring容器中所有bean如下：");

        //getBeanDefinitionNames用于获取容器中所有bean的名称
        for (String beanName : context.getBeanDefinitionNames()) {
            //获取bean的别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
        }

    }
}