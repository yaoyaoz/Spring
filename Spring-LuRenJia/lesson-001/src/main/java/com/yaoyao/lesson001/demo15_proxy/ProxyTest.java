package com.yaoyao.lesson001.demo15_proxy;

import org.junit.Test;

/**
 * ClassName: ProxyTest
 * Description:
 * Date: 2020年08月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ProxyTest {
    @Test
    public void m1() {
        IService serviceA = new ServiceProxy(new ServiceA());
        IService serviceB = new ServiceProxy(new ServiceB());
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
    }
}
