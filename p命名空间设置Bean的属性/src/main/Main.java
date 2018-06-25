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
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
        //Student{name='Tom', age=55, height=185.0, books=[Book{name='Java', price=15.55}, Book{name='Go', price=20.0}, Book{name='Python', price=99.99}]}
    }
}
