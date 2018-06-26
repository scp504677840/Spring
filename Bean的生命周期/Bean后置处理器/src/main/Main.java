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

        //单个Bean的生命周期
        //fun1(ctx);

        Book book = (Book) ctx.getBean("book");
        System.out.println(book);

        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        ((ClassPathXmlApplicationContext) ctx).close();
        //book : call构造函数
        //book : call setName
        //book : call setPrice
        //postProcessBeforeInitialization: book --- Book{name='Java', price=22.55}
        //book : call init
        //postProcessAfterInitialization: book --- Book{name='Java', price=22.55}
        //address : call 构造函数
        //address : call setCity
        //address : call setStreet
        //postProcessBeforeInitialization: address --- Address{city='Shanghai', street='NanJingDongLu'}
        //address : call init
        //postProcessAfterInitialization: address --- Address{city='Shanghai', street='NanJingDongLu'}

        //Book{name='Java', price=22.55}
        //Address{city='Shanghai', street='NanJingDongLu'}

        //address : call destroy
        //book : call destroy

    }

    private static void fun1(ApplicationContext ctx) {
        Book book = (Book) ctx.getBean("book");
        System.out.println(book);
        ((ClassPathXmlApplicationContext) ctx).close();
        //call构造函数
        //call setName
        //call setPrice
        //postProcessBeforeInitialization: book --- Book{name='Java', price=22.55}
        //call init
        //postProcessAfterInitialization: book --- Book{name='Java', price=22.55}
        //Book{name='Java', price=22.55}
        //call destroy
    }

}
