package com.yaoyao.lesson001.demo16_jdk_proxy;

/**
 * ClassName: UserServiceImpl
 * Description:
 * Date: 2020年08月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void insert(String name) {
        System.out.println(String.format("用户[name:%s]插入成功!", name));
    }
}
