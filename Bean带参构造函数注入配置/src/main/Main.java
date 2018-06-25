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
        //fun1();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }

    private static void fun1() {
        //1.创建Spring IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从IOC容器中获取Bean
        Hi hi = (Hi) ctx.getBean("hi");
        //利用Bean类型获取实例
        //Hi hi = ctx.getBean(Hi.class);
        //3.调用hi方法
        hi.Hi();

        //打印结果
        //spring ioc
        //Hi!!!Spring
    }

}
