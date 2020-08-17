package com.yaoyao.lesson001.demo15_proxy;

/**
 * ClassName: ServiceProxy
 * Description: IService的代理类
 * Date: 2020年08月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ServiceProxy implements IService {
    //目标对象，被代理的对象
    private IService target;

    public ServiceProxy(IService target) {
        this.target = target;
    }

    @Override
    public void m1() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m2()方法耗时(纳秒):" + (endTime - starTime));
    }

    @Override
    public void m2() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m2()方法耗时(纳秒):" + (endTime - starTime));
    }

    @Override
    public void m3() {
        long starTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m3()方法耗时(纳秒):" + (endTime - starTime));
    }
}
