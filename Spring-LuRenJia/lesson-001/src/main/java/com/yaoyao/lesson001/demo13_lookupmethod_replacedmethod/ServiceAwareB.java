package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName: ServiceAwareB
 * Description:
 * Date: 2020年08月13日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceAwareB implements ApplicationContextAware {

    private ApplicationContext context;

    /**
     * spring容器在创建ServiceAwareB的时候会自动调用setApplicationContext方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void say(){
        ServiceA serviceA = this.getServiceA();
        System.out.println("this:"+this+",serviceA:"+ serviceA);
    }

    /**
     * 从容器中主动去获取ServiceA，这样每次获取到的ServiceA都是一个新的实例
     * @return
     */
    public ServiceA getServiceA() {
        return this.context.getBean(ServiceA.class);
    }
}
