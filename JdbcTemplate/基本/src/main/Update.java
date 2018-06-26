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
public class Update {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        //常用更新方式一：
        //String sql="update hero set name = 'jt' where id = 1";
        //System.out.println(jdbcTemplate.update(sql));

        //常用更新方式二：
        String sql = "update hero set name = ? where id = ?";
        Object[] params = new Object[]{"new jt", 1};
        System.out.println(jdbcTemplate.update(sql, params));
    }

}
