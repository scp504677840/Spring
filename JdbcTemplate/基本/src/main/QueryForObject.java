package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class QueryForObject {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "select id,gmt_create gmtCreate,gmt_modified gmtModified,name from hero where id = 1";
        RowMapper<Hero> rm = new BeanPropertyRowMapper<>(Hero.class);
        Hero hero = jdbcTemplate.queryForObject(sql, rm);
        System.out.println(hero);
    }

}
