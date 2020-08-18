package com.yaoyao.lesson001.demo20_configuration_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * ClassName: ConfigBean2
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Configuration //加了就是代理，下面的bean就是单例的。不加就是多例
public class ConfigBean2 {
    @Bean
    public ServiceA serviceA() {
        System.out.println("调用serviceA()方法"); //@0
        return new ServiceA();
    }

    @Bean
    ServiceB serviceB1() {
        System.out.println("调用serviceB1()方法");
        ServiceA serviceA = this.serviceA(); //@1
        return new ServiceB(serviceA);
    }

    @Bean
    ServiceB serviceB2() {
        System.out.println("调用serviceB2()方法");
        ServiceA serviceA = this.serviceA(); //@2
        return new ServiceB(serviceA);
    }
}
