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
        Book book = (Book) ctx.getBean("book");
        System.out.println(book);
        ((ClassPathXmlApplicationContext) ctx).close();
        //call构造函数
        //call setName
        //call setPrice
        //call init
        //Book{name='Java', price=22.55}
        //call destroy
    }

}
