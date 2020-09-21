package com.yaoyao.lesson001.demo24_import;

import com.yaoyao.lesson001.demo24_import.test1.MainConfig1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: ImportTest
 * Description:
 * Date: 2020年08月19日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class ImportTest {

    /*
    从输出中可以看出：
    Service1和Service2成功注册到容器了。
    通过@Import导入的2个类，bean名称为完整的类名

    也可以指定被导入类的bean名称，使用@Compontent注解就可以了
     */
    @Test
    public void test1() {
        //1.通过AnnotationConfigApplicationContext创建spring容器，参数为@Import标注的类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        //2.输出容器中定义的所有bean信息
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
