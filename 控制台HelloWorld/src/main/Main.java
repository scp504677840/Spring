package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //1.创建Spring IOC容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从IOC容器中获取Bean
        Hi hi = (Hi) ctx.getBean("hi");
        //3.调用hi方法
        hi.Hi();

        //打印结果
        //spring ioc
        //Hi!!!Spring
    }

}
