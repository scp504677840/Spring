package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class BatchUpdate {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "update hero set name = ? where id = ?";
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{"AA", 11});
        params.add(new Object[]{"BB", 12});
        params.add(new Object[]{"CC", 13});
        params.add(new Object[]{"DD", 14});
        params.add(new Object[]{"EE", 15});
        System.out.println(jdbcTemplate.batchUpdate(sql, params).length);
    }

}
