package com.yaoyao.lesson001.demo26_autowired.test0;

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

    public Service2() { //@1
        System.out.println(this.getClass() + "无参构造器");
    }

    @Autowired
    public Service2(Service1 service1) { //@2
        System.out.println(this.getClass() + "有参构造器");
        this.service1 = service1;
    }

    @Override
    public String toString() { //@2
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
