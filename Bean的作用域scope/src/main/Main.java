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

        //singleton
        //singleton(ctx);

        //prototype
        //prototype(ctx);

        //下面两种情况后续讨论
        //Book request = (Book) ctx.getBean("request");
        //System.out.println("request: " + request);
        //Book session = (Book) ctx.getBean("session");
        //System.out.println("session: " + session);
    }

    private static void prototype(ApplicationContext ctx) {
        Book prototype1 = (Book) ctx.getBean("prototype");
        Book prototype2 = (Book) ctx.getBean("prototype");
        System.out.println("prototype1: " + prototype1);
        System.out.println("prototype2: " + prototype2);
        System.out.println(prototype1 == prototype2);
        //call构造函数 //此处是Spring IOC 初始化Bean实例时调用的
        //call构造函数
        //call构造函数
        //prototype1: Book{name='Prototype', price=22.0}
        //prototype2: Book{name='Prototype', price=22.0}
        //false
    }

    private static void singleton(ApplicationContext ctx) {
        Book singleton1 = (Book) ctx.getBean("singleton");
        Book singleton2 = (Book) ctx.getBean("singleton");
        System.out.println(singleton1 == singleton2);
        //call构造函数
        //true
    }
}
