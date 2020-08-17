package com.yaoyao.lesson001.demo16_jdk_proxy;

/**
 * ClassName: ServiceA
 * Description:
 * Date: 2020年08月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceA implements IService {
    @Override
    public void m1() {
        System.out.println("我是ServiceA中的m1方法!");
    }

    @Override
    public void m2() {
        System.out.println("我是ServiceA中的m2方法!");
    }

    @Override
    public void m3() {
        System.out.println("我是ServiceA中的m3方法!");
    }

    public void m4() {
        System.out.println("我是ServiceA中的m4方法!");
    }
}
