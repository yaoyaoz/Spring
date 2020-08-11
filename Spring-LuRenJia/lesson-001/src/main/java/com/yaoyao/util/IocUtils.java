package com.yaoyao.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: IocUtils
 * Description:
 * Date: 2020年08月11日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class IocUtils {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

}
