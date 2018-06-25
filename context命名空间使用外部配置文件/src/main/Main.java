package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println("dataSource: " + dataSource);
        //dataSource: com.mchange.v2.c3p0.ComboPooledDataSource[ identityToken -> 1hge0yy9wfn7vc31vmt35g|47faa49c, dataSourceName -> 1hge0yy9wfn7vc31vmt35g|47faa49c ]
    }

}
