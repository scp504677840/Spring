package main.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletContextListener implements ServletContextListener {

    public SpringServletContextListener() {
        System.out.println("SpringServletContextListener");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取ServletContext
        ServletContext servletContext = sce.getServletContext();
        //2.获取Spring配置文件路径
        String springConfigLocation = servletContext.getInitParameter("springConfigLocation");
        //3.初始化ApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext(springConfigLocation);
        //4.将ApplicationContext放入Servlet的application域中。
        servletContext.setAttribute("ApplicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
