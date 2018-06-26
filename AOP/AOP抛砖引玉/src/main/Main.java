package main;

import main.controller.BookController;
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

        //第一版：纯粹
        //fun1();

        //第二版：加上日志
        //fun2();

        //第三版：代理版本
        //fun3();

    }

    private static void fun3() {
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator ac = new ArithmeticCalculatorLogProxy(target).getLogProxy();
        double x = 2;
        double y = 1;
        System.out.println(ac.add(x, y));
        System.out.println(ac.subtract(x, y));
        System.out.println(ac.multiply(x, y));
        System.out.println(ac.divide(x, y));
        //代理方法执行前。。。
        //代理方法执行后。。。
        //3.0
        //代理方法执行前。。。
        //代理方法执行后。。。
        //1.0
        //代理方法执行前。。。
        //代理方法执行后。。。
        //2.0
        //代理方法执行前。。。
        //代理方法执行后。。。
        //2.0
    }

    private static void fun2() {
        ArithmeticCalculator ac = new ArithmeticCalculatorLogImpl();
        double x = 2;
        double y = 1;
        System.out.println(ac.add(x, y));
        System.out.println(ac.subtract(x, y));
        System.out.println(ac.multiply(x, y));
        System.out.println(ac.divide(x, y));

        //第二版：加了日志
        //Main add before
        //Main add after
        //3.0
        //Main subtract before
        //Main subtract after
        //1.0
        //Main multiply before
        //Main multiply after
        //2.0
        //Main divide before
        //Main divide after
        //2.0
    }

    private static void fun1() {
        ArithmeticCalculator ac = new ArithmeticCalculatorImpl();
        double x = 2;
        double y = 1;
        System.out.println(ac.add(x, y));
        System.out.println(ac.subtract(x, y));
        System.out.println(ac.multiply(x, y));
        System.out.println(ac.divide(x, y));

        //第一版：纯粹
        //3.0
        //1.0
        //2.0
        //2.0
    }

}
