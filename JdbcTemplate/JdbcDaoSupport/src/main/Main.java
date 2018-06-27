package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //setIgnoreWarnings
        //isIgnoreWarnings
        System.out.println(jdbcTemplate.isIgnoreWarnings());
        //true

        //setFetchSize
        //getFetchSize
        System.out.println(jdbcTemplate.getFetchSize());
        //-1

        //setMaxRows
        //getMaxRows
        System.out.println(jdbcTemplate.getMaxRows());
        //-1

        //setQueryTimeout
        //getQueryTimeout
        System.out.println(jdbcTemplate.getQueryTimeout());
        //-1

        //setSkipResultsProcessing
        //isSkipResultsProcessing
        System.out.println(jdbcTemplate.isSkipResultsProcessing());
        //false

        //setSkipUndeclaredResults
        //isSkipUndeclaredResults
        System.out.println(jdbcTemplate.isSkipUndeclaredResults());
        //false

        //setResultsMapCaseInsensitive
        //isResultsMapCaseInsensitive
        System.out.println(jdbcTemplate.isResultsMapCaseInsensitive());
        //false

        //调用函数或存储过程
        //call
        //jdbcTemplate.call()
    }

}
