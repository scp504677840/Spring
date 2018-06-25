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
        Student outStudent = (Student) ctx.getBean("student");
        System.out.println(outStudent);
        //Student{name='Tom', age=22, height=180.0, book=Book{name='Python', price=199.0}}
    }
}
