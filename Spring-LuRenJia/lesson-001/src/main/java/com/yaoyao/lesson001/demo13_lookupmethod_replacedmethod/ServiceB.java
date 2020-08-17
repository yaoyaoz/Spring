package com.yaoyao.lesson001.demo13_lookupmethod_replacedmethod;

/**
 * ClassName: ServiceB
 * Description:
 * Date: 2020年08月12日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceB {
    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void say() {
        ServiceA serviceA = this.getServiceA();
        System.out.println("this:" + this + ",serviceA:" + serviceA);
    }
}
