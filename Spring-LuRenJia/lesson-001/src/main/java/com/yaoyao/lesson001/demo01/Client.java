package com.yaoyao.lesson001.demo01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        String beanXml = "classpath:com/yaoyao/lesson001/demo01/beans.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        //3.从容器中获取需要的bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);

        //4.使用对象
        helloWorld.say();
    }
}