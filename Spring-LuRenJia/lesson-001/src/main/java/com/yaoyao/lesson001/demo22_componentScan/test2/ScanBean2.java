package com.yaoyao.lesson001.demo22_componentScan.test2;

import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ScanBean2
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@ComponentScan({
        "com.yaoyao.lesson001.demo22_componentScan.test1.controller",
        "com.yaoyao.lesson001.demo22_componentScan.test1.dao"
})
public class ScanBean2 {
}
