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

    /**
     * 1.书写ArithmeticCalculator
     * 2.书写ArithmeticCalculatorImpl，并加上@Component注解
     * 3.下载AspectJ的jar包并加入工程依赖
     * 4.书写LogAspect并加上@Component和@Aspect注解
     * 5.书写spring-config.xml配置文件
     * 6.书写Main，完成！
     *
     * 注意：
     * 在测试异常通知时，记得在ArithmeticCalculatorImpl的divide方法里面制造异常！！！
     *
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ArithmeticCalculator ac = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        //注意：我们在此故意制造异常，来验证后置通知是否不受异常干扰继续执行。
        System.out.println(ac.divide(1, 0));
        //前置通知： divide
        //java.lang.ArithmeticException: / by zero
        //异常通知： divide
        //Exception in thread "main" java.lang.RuntimeException: java.lang.ArithmeticException: / by zero
        //LogAspect 异常通知： divide --- java.lang.ArithmeticException: / by zero
        //	... 15 more

    }

}
