package com.yaoyao.lesson001.demo22_componentScan.test6;

import com.yaoyao.lesson001.demo22_componentScan.test2.ScanBean2;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ScanBean6
 * Description:
 * Date: 2020年08月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@ComponentScan(basePackageClasses = ScanClass.class)
public class ScanBean6 {
}
