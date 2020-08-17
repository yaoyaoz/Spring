package com.yaoyao.lesson001.demo12_abstract_parent;

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
    private String name;
    private ServiceA serviceA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public String toString() {
        return "ServiceB{" +
                "name='" + name + '\'' +
                ", serviceA=" + serviceA +
                '}';
    }
}
