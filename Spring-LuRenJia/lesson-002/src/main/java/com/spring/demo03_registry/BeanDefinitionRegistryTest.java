package com.spring.demo03_registry;

import com.spring.demo01.J02_User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

/**
 * ClassName: BeanDefinitionRegistryTest
 * Description: 阶段3：将Bean注册到容器中
 * Date: 2020年10月12日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class BeanDefinitionRegistryTest {
    @Test
    public void test1() {
        //创建一个bean工厂，这个默认实现了BeanDefinitionRegistry接口，所以也是一个bean注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义一个bean
        GenericBeanDefinition nameBdf = new GenericBeanDefinition();
        nameBdf.setBeanClass(String.class);
        nameBdf.getConstructorArgumentValues().addIndexedArgumentValue(0, "路人甲Java");

        GenericBeanDefinition nameBdf1 = new GenericBeanDefinition();
        nameBdf1.setBeanClass(J02_User.class);
        nameBdf1.getConstructorArgumentValues().addIndexedArgumentValue(0, "路人甲Java");


        //将bean注册到容器中
        factory.registerBeanDefinition("name", nameBdf);
        factory.registerBeanDefinition("user", nameBdf1);

        //通过名称获取BeanDefinition
        System.out.println("通过名称获取BeanDefinition:" + factory.getBeanDefinition("name"));
        //通过名称判断是否注册过BeanDefinition
        System.out.println("通过名称判断是否注册过BeanDefinition:" + factory.containsBeanDefinition("name"));
        //获取所有注册的名称
        System.out.println("获取所有注册的名称:" + Arrays.asList(factory.getBeanDefinitionNames()));
        //获取已注册的BeanDefinition的数量
        System.out.println("获取已注册的BeanDefinition的数量" + factory.getBeanDefinitionCount());
        //判断指定的name是否使用过
        System.out.println("判断指定的name是否使用过:" + factory.isBeanNameInUse("name"));

        //别名相关方法
        //为name注册2个别名
        factory.registerAlias("name", "alias-name-1");
        factory.registerAlias("name", "alias-name-2");

        //判断alias-name-1是否已被作为别名使用
        System.out.println("判断alias-name-1是否已被作为别名使用:" + factory.isAlias("alias-name-1"));

        //通过名称获取对应的所有别名
        System.out.println("通过名称获取对应的所有别名:" + Arrays.asList(factory.getAliases("name")));

        //最后我们再来获取一下这个bean
        System.out.println("最后我们再来获取一下这个bean:" + factory.getBean("name"));
    }
}
