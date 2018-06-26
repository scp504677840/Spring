package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Book java = (Book) ctx.getBean("java");
        System.out.println(java);
        Book go = (Book) ctx.getBean("go");
        System.out.println(go);
        Book python = (Book) ctx.getBean("python");
        System.out.println(python);
        //Book{name='java', price=11.55}
        //Book{name='go', price=22.55}
        //Book{name='python', price=33.55}
    }

}
