package main;

import main.controller.ShopInfoController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ShopInfoController shopInfoController = (ShopInfoController) ctx.getBean("shopInfoController");
        shopInfoController.buy(BigInteger.valueOf(1L),"java");
    }
}
