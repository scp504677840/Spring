package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class QueryForRowSet {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "select id,gmt_create,gmt_modified,name from hero where id = 1";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        SqlRowSetMetaData metaData = sqlRowSet.getMetaData();

        while (sqlRowSet.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String name = metaData.getColumnName(i + 1);
                Object value = sqlRowSet.getObject(name);
                System.out.println(name + " : " + value);
            }
        }
        //id : 1
        //gmt_create : 2018-06-24 18:40:31.0
        //gmt_modified : 2018-06-24 18:40:31.0
        //name : Tom
    }

}
