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

        //抽象配置不可实例化
        //Address address = (Address) ctx.getBean("address");
        //System.out.println(address);

        Address address1 = (Address) ctx.getBean("address1");
        System.out.println(address1);

        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        //Address{city='Shanghai', street='NanJingXiLu'}
        //Address{city='Shanghai', street='YuYuan'}
    }
}
