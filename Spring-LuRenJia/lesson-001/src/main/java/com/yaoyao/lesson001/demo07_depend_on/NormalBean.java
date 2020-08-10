package com.yaoyao.lesson001.demo07_depend_on;

import org.springframework.beans.factory.DisposableBean;

/**
 * ClassName: NormalBean
 * Description: 无任何依赖的bean创建的顺序
 * Date: 2020年08月08日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class NormalBean {

    public static class Bean1 implements DisposableBean {

        public Bean1() {
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class Bean2 implements DisposableBean {

        public Bean2() {
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class Bean3 implements DisposableBean {

        public Bean3() {
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

}
