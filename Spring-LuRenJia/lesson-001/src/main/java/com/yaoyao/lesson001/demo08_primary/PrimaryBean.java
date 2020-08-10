package com.yaoyao.lesson001.demo08_primary;

/**
 * ClassName: PrimaryBean
 * Description: 使用primary来解决上面案例的问题
 * Date: 2020年08月10日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class PrimaryBean {
    public interface IService{} //@1
    public static class ServiceA implements IService{} //@2
    public static class ServiceB implements IService{} //@3

    private IService service;

    public void setService(IService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "PrimaryBean{" +
                "service=" + service +
                '}';
    }
}
