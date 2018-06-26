package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class QueryForMap {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "select id,gmt_create,gmt_modified,name from hero where id = 1";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        map.forEach((s, o) -> {
            System.out.println(s + " : " + o);
        });
        //id : 1
        //gmt_create : 2018-06-24 18:40:31.0
        //gmt_modified : 2018-06-24 18:40:31.0
        //name : Tom
    }

}
