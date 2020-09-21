package com.yaoyao.lesson001.demo24_import.test1;

import org.springframework.context.annotation.Import;

/**
 * ClassName: MainConfig1
 * Description:
 * Date: 2020年08月19日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Import({Service1.class, Service2.class})
public class MainConfig1 {
}
