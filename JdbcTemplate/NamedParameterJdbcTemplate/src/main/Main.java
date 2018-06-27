package main;

import main.entities.Hero;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");

        //传入Map
        //fun1(namedParameterJdbcTemplate);

        //传入对象，更简洁
        //fun2(namedParameterJdbcTemplate);
    }

    private static void fun2(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        String sql = "insert into hero (gmt_create, gmt_modified, name) values (:gmtCreate,:gmtModified,:name)";
        Hero hero = new Hero(Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), "Joy");
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(hero);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    private static void fun1(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        String sql = "insert into hero (gmt_create, gmt_modified, name) values (:gmtCreate,:gmtModified,:name)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gmtCreate", Timestamp.from(Instant.now()));
        paramMap.put("gmtModified", Timestamp.from(Instant.now()));
        paramMap.put("name", "Cher");
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

}
