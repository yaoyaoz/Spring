package com.yaoyao.lesson001.demo03;

/**
 * ClassName: UserFactory
 * Description: 定义一个实例工厂
 * Date: 2020年07月24日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class UserFactory {
    public UserModel buildUser1() {
        System.out.println("----------------------1");
        UserModel userModel = new UserModel();
        userModel.setName("bean实例方法创建的对象!");
        return userModel;
    }

    public UserModel buildUser2(String name, int age) {
        System.out.println("----------------------2");
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }
}