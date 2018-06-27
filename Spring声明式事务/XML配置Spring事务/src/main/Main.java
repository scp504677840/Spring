package main;

import main.controller.ShopInfoController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    /**
     * Spring 声明式事务
     * 1.配置事务管理器
     * <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     *     <property name="dataSource" ref="dataSource"/>
     * </bean>
     * 2.启用事务注解
     * <tx:annotation-driven transaction-manager="transactionManager"/>
     * 3.添加事务注解
     * 在方法上添加 @Transactional 注解
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ShopInfoController shopController = (ShopInfoController) ctx.getBean("shopInfoController");
        shopController.buy(BigInteger.valueOf(1L), "java");
    }

}
