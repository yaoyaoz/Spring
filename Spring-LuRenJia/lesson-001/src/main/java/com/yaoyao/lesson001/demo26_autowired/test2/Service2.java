package com.yaoyao.lesson001.demo26_autowired.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: Service2
 * Description:
 * Date: 2020年08月20日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Component
public class Service2 {
    private Service1 service1;

    @Autowired
    public void setService1(Service1 service1) { //@1
        System.out.println(this.getClass().getName() + ".setService1方法");
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
