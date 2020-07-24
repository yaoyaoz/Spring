package com.yaoyao.lesson001.demo03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName: UserModel
 * Description:
 * Date: 2020年07月24日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Getter
@Setter
@ToString
public class UserModel {
    private String name;
    private int age;

    public UserModel() {
        this.name = "我是通过UserModel的无参构造方法创建的!";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}