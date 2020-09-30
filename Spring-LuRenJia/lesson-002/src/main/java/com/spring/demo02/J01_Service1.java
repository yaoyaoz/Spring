package com.spring.demo02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * ClassName: J01_Service1
 * Description:
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
@Lazy
public class J01_Service1 {
}
