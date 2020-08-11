package com.yaoyao.lesson001.demo09_autowire_candidate;

import com.yaoyao.util.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: AutowireCandidateTest
 * Description:
 * Date: 2020年08月11日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class AutowireCandidateTest {

    @Test
    public void setterBean() {
        String beanXml = "classpath:com/yaoyao/lesson001/demo09_autowire_candidate/autowireCandidateBean.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean(SetterBean.class)); //@1

        SetterBean.IService service = context.getBean(SetterBean.IService.class); //@2
        System.out.println(service);
    }

}
