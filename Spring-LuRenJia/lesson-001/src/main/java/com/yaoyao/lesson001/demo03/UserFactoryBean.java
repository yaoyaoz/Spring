package com.yaoyao.lesson001.demo03;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * ClassName: UserFactoryBean
 * Description: 创建一个FactoryBean实现类
 * Date: 2020年07月24日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class UserFactoryBean implements FactoryBean<UserModel> {

    int count = 1;

    @Nullable
    @Override
    public UserModel getObject() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setName("我是通过FactoryBean创建的第" + count++ + "个对象");//@4
        return userModel;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return UserModel.class; //@2
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}