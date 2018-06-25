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

        Student studentOne = (Student) ctx.getBean("studentOne");
        Student studentTwo = (Student) ctx.getBean("studentTwo");

        System.out.println(studentOne);
        System.out.println(studentTwo);

        //Student{name='调用第二个参数为int类型的构造函数', age=10, height=0.0}
        //Student{name='调用第二个参数为double类型的构造函数', age=0, height=1.55}
    }
}
