package com.spring.demo01;

/**
 * ClassName: J02_User
 * Description:
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J02_User {
    private String name;

    private J01_Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public J01_Car getCar() {
        return car;
    }

    public void setCar(J01_Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
