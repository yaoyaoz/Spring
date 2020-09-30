package com.spring.demo01;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;

import java.util.Arrays;

/**
 * ClassName: BeanDefinitionTest
 * Description: Spring bean生命周期13个环节：阶段1：Bean元信息配置阶段
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class BeanDefinitionTest {

    /**
     * 等效于<bean class="com.spring.demo01.J01_Car" />
     */
    @Test
    public void test1() {
        //指定class
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(J01_Car.class.getName());
        //获取BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        log.info("返回结果：beanDefinition=【{}】", beanDefinition);
    }

    /**
     * 组装一个有属性的bean
     */
    @Test
    public void test2() {
        //指定class
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(J01_Car.class.getName());
        //设置普通类型属性
        beanDefinitionBuilder.addPropertyValue("name", "奥迪"); //@1
        //获取BeanDefinition
        BeanDefinition carBeanDefinition = beanDefinitionBuilder.getBeanDefinition();
        log.info("返回结果：beanDefinition=【{}】", carBeanDefinition);

        //创建spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); //@2
        //调用registerBeanDefinition向容器中注册bean
        factory.registerBeanDefinition("car", carBeanDefinition); //@3
        J01_Car bean = factory.getBean("car", J01_Car.class); //@4
        log.info("返回结果：bean=【{}】", bean);
    }

    /**
     * 组装一个有依赖关系的bean
     *
     * 等效于
     * <bean id="car" class="com.javacode2018.lesson002.demo1.Car">
     *     <property name="name" value="奥迪"/>
     * </bean>
     * <bean id="user" class="com.javacode2018.lesson002.demo1.User">
     *     <property name="name" value="路人甲Java"/>
     *     <property name="car" ref="car"/>
     * </bean>
     */
    @Test
    public void test3() {
        //先创建car这个BeanDefinition
        BeanDefinition carBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(J01_Car.class.getName())
                .addPropertyValue("name", "奥迪").getBeanDefinition();
        //创建User这个BeanDefinition
        BeanDefinition userBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(J02_User.class.getName()).
                addPropertyValue("name", "路人甲Java").
                addPropertyReference("car", "car"). //@1
                getBeanDefinition();

        //创建spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //调用registerBeanDefinition向容器中注册bean
        factory.registerBeanDefinition("car", carBeanDefinition);
        factory.registerBeanDefinition("user", userBeanDefinition);
        log.info("car=【{}】", factory.getBean("car"));
        log.info("user=【{}】", factory.getBean("user"));
    }

    /**
     * 来2个有父子关系的bean
     *
     * 等效于
     * <bean id="car1" class="com.javacode2018.lesson002.demo1.Car">
     *     <property name="name" value="保时捷"/>
     * </bean>
     * <bean id="car2" parent="car1" />
     */
    @Test
    public void test4() {
        //先创建car这个BeanDefinition
        BeanDefinition carBeanDefinition1 = BeanDefinitionBuilder.
                genericBeanDefinition(J01_Car.class).
                addPropertyValue("name", "保时捷").
                getBeanDefinition();

        BeanDefinition carBeanDefinition2 = BeanDefinitionBuilder.
                genericBeanDefinition(). //内部生成一个GenericBeanDefinition对象
                setParentName("car1"). //@1：设置父bean的名称为car1
                getBeanDefinition();

        //创建spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //调用registerBeanDefinition向容器中注册bean
        //注册car1->carBeanDefinition1
        factory.registerBeanDefinition("car1", carBeanDefinition1);
        //注册car2->carBeanDefinition2
        factory.registerBeanDefinition("car2", carBeanDefinition2);
        //从容器中获取car1
        log.info("car1=【{}】", factory.getBean("car1"));
        //从容器中获取car2
        log.info("car2=【{}】", factory.getBean("car2"));
    }

    /**
     * 通过api设置（Map、Set、List）属性
     *
     * 等效于
     * <bean id="car1" class="com.javacode2018.lesson002.demo1.Car">
     * 	<property name="name" value="奥迪"/>
     * </bean>
     *
     * <bean id="car2" class="com.javacode2018.lesson002.demo1.Car">
     * 	<property name="name" value="保时捷"/>
     * </bean>
     *
     * <bean id="compositeObj" class="com.javacode2018.lesson002.demo1.CompositeObj">
     * 	<property name="name" value="路人甲Java"/>
     * 	<property name="salary" value="50000"/>
     * 	<property name="car1" ref="car1"/>
     * 	<property name="stringList">
     * 		<list>
     * 			<value>java高并发系列</value>
     * 			<value>mysql系列</value>
     * 			<value>maven高手系列</value>
     * 		</list>
     * 	</property>
     * 	<property name="carList">
     * 		<list>
     * 			<ref bean="car1"/>
     * 			<ref bean="car2"/>
     * 		</list>
     * 	</property>
     * 	<property name="stringSet">
     * 		<set>
     * 			<value>java高并发系列</value>
     * 			<value>mysql系列</value>
     * 			<value>maven高手系列</value>
     * 		</set>
     * 	</property>
     * 	<property name="carSet">
     * 		<set>
     * 			<ref bean="car1"/>
     * 			<ref bean="car2"/>
     * 		</set>
     * 	</property>
     * 	<property name="stringMap">
     * 		<map>
     * 			<entry key="系列1" value="java高并发系列"/>
     * 			<entry key="系列2" value="Maven高手系列"/>
     * 			<entry key="系列3" value="mysql系列"/>
     * 		</map>
     * 	</property>
     * 	<property name="stringCarMap">
     * 		<map>
     * 			<entry key="car1" value-ref="car1"/>
     * 			<entry key="car2" value-ref="car2"/>
     * 		</map>
     * 	</property>
     * </bean>
     */
    @Test
    public void test5() {
        //定义car1
        BeanDefinition car1 = BeanDefinitionBuilder.
                genericBeanDefinition(J01_Car.class).
                addPropertyValue("name", "奥迪").
                getBeanDefinition();
        //定义car2
        BeanDefinition car2 = BeanDefinitionBuilder.
                genericBeanDefinition(J01_Car.class).
                addPropertyValue("name", "保时捷").
                getBeanDefinition();

        //定义CompositeObj这个bean
        //创建stringList这个属性对应的值
        ManagedList<String> stringList = new ManagedList<>();
        stringList.addAll(Arrays.asList("java高并发系列", "mysql系列", "maven高手系列"));

        //创建carList这个属性对应的值,内部引用其他两个bean的名称[car1,car2]
        ManagedList<RuntimeBeanReference> carList = new ManagedList<>();
        carList.add(new RuntimeBeanReference("car1"));
        carList.add(new RuntimeBeanReference("car2"));

        //创建stringList这个属性对应的值
        ManagedSet<String> stringSet = new ManagedSet<>();
        stringSet.addAll(Arrays.asList("java高并发系列", "mysql系列", "maven高手系列"));

        //创建carSet这个属性对应的值,内部引用其他两个bean的名称[car1,car2]
        ManagedList<RuntimeBeanReference> carSet = new ManagedList<>();
        carSet.add(new RuntimeBeanReference("car1"));
        carSet.add(new RuntimeBeanReference("car2"));

        //创建stringMap这个属性对应的值
        ManagedMap<String, String> stringMap = new ManagedMap<>();
        stringMap.put("系列1", "java高并发系列");
        stringMap.put("系列2", "Maven高手系列");
        stringMap.put("系列3", "mysql系列");

        ManagedMap<String, RuntimeBeanReference> stringCarMap = new ManagedMap<>();
        stringCarMap.put("car1", new RuntimeBeanReference("car1"));
        stringCarMap.put("car2", new RuntimeBeanReference("car2"));

        //下面我们使用原生的api来创建BeanDefinition
        GenericBeanDefinition compositeObj = new GenericBeanDefinition();
        compositeObj.setBeanClassName(J03_CompositeObj.class.getName());
        compositeObj.getPropertyValues().add("name", "路人甲Java").
                add("salary", 50000).
                add("car1", new RuntimeBeanReference("car1")).
                add("stringList", stringList).
                add("carList", carList).
                add("stringSet", stringSet).
                add("carSet", carSet).
                add("stringMap", stringMap).
                add("stringCarMap", stringCarMap);

        //将上面bean 注册到容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car1", car1);
        factory.registerBeanDefinition("car2", car2);
        factory.registerBeanDefinition("compositeObj", compositeObj);

        //下面我们将容器中所有的bean输出
        for (String beanName : factory.getBeanDefinitionNames()) {
            log.info("beanName=【{}】, bean=【{}】", beanName, factory.getBean(beanName));
        }
    }

}
