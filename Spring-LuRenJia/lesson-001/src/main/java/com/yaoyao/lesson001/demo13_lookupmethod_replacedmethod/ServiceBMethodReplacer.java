package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * ClassName: ServiceBMethodReplacer
 * Description: servieB的方法替换者
 * Date: 2020年08月14日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceBMethodReplacer implements MethodReplacer, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return this.context.getBean(ServiceA.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
