package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

/**
 * ClassName: ServiceLookupB
 * Description: 演示lookup-method
 * Date: 2020年08月13日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceLookupB {

    public void say() {
        ServiceA serviceA = this.getServiceA();
        System.out.println("this:" + this + ",serviceA:" + serviceA);
    }

    /**
     * 这个方法中返回了一个null对象，通过spring来创建ServiceLookupB对象，然后让spring对getServiceA方法进行拦截，返回指定的bean
     * @return
     */
    public ServiceA getServiceA() { //@1
        return null;
    }

}
