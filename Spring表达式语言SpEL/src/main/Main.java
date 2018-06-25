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

        Address address = (Address) ctx.getBean("address");
        System.out.println("address: " + address);

        Book book = (Book) ctx.getBean("book");
        System.out.println("book: " + book);

        Student student = (Student) ctx.getBean("student");
        System.out.println("student: " + student);

        //address: Address{city='Shanghai', street='NanJingDongLu'}
        //book: Book{name='Java', price=0.28411220039712515}
        //student: Student{name='Tom', age=2, height=180.0, city='Shanghai', book=Book{name='Java', price=0.28411220039712515}}
    }

}
