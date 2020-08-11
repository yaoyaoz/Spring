package com.yaoyao.lesson001.demo09_autowire_candidate;

import java.util.List;

/**
 * ClassName: SetterBean
 * Description:
 * Date: 2020年08月11日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class SetterBean {
    public interface IService {} //@1

    public static class ServiceA implements IService {} //@2

    public static class ServiceB implements IService {} //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }

    public void setService1(List<IService> service) {//@0
        System.out.println("setService1: " + service); //@1
    }

    @Override
    public String toString() {
        return "SetterBean{" +
                "service=" + service +
                '}';
    }
}
