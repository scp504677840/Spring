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

        //byName
        Student student1 = (Student) ctx.getBean("student1");
        System.out.println(student1);
        //Student{name='Tom', age=30, height=180.0, address=Address{city='Shanghai'}, book=Book{name='Java', price=55.0}}

        //byType
        Student student2 = (Student) ctx.getBean("student2");
        System.out.println(student2);
        //Student{name='Tom', age=30, height=180.0, address=Address{city='Shanghai'}, book=Book{name='Java', price=55.0}}
    }
}
