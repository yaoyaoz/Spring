package com.yaoyao.lesson001.demo08_primary;

/**
 * ClassName: SetterBean
 * Description: 通过setter方法注入的案例
 * Date: 2020年08月10日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class SetterBean {
    public interface IService{} //@1
    public static class ServiceA implements IService{} //@2
    public static class ServiceB implements IService{} //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }
}
