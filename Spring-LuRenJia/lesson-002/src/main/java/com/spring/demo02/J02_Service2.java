package com.spring.demo02;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: J02_Service2
 * Description:
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J02_Service2 {

    @Autowired
    private J01_Service1 service1; //@1

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }

}
