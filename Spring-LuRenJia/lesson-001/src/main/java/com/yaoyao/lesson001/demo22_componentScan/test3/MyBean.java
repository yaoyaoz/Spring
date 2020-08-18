package com.yaoyao.lesson001.demo22_componentScan.test3;

import java.lang.annotation.*;

/**
 * ClassName: MyBean
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBean {
}
