package com.spring.demo01;

/**
 * ClassName: J01_Car
 * Description:
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J01_Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
