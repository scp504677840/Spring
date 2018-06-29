package main.controller;

import com.opensymphony.xwork2.ActionSupport;
import main.service.ShopInfoService;

import java.math.BigInteger;

/**
 * 整合Struts2 与 Spring
 * 1.Spring IOC 容器何时初始化？
 * 在Servlet容器启动时进行初始化，所以监听Servlet启动即可。具体参看web.xml文件。
 * 2.Spring IOC 容器初始化好了之后存在何处？后续我们要使用的时候如何取？
 * Spring IOC 容器初始化好了以后，存在ServletContext里面。
 * 后续我们如果想要使用，直接从ServletContext里面取就好了。
 * 因为我们存在ServletContext里面，所以Spring IOC的生命周期和ServletContext的生命周期一致。
 * 3.Struts2的Action与Spring整合后，在配置方面会有怎样的变化？
 * 首先Struts2的Action的创建会交给Spring IOC 容器，所以在Spring配置文件中配置ActionBean。
 * 然后Struts配置文件的action class就直接写在Spring配置文件中id值即可。具体如下：
 * spring-config.xml部分配置：
 * <bean id="shopInfoAction" class="main.ShopInfoAction" scope="prototype">
 * 我们可以看到有一个scope属性，这里因为我们每一个Struts2的Action对应一次请求。所以Action的创建一定要是非单例的。
 * struts.xml部分配置：
 * action的class指向Spring-config里Action的Id
 * <action name="shopInfo" class="shopInfoAction" method="execute">
 * <result name="success">/shopInfo.jsp</result>
 * </action>
 * 4.注意：一定要加入 struts2-spring-plugin-2.5.16.jar 的包！！！
 * 5.完成！
 */
public class ShopInfoAction extends ActionSupport {

    private ShopInfoService shopInfoService;

    public void setShopInfoService(ShopInfoService shopInfoService) {
        this.shopInfoService = shopInfoService;
    }

    @Override
    public String execute() throws Exception {
        //演示ApplicationContext
        //ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        //ShopInfo shopInfo = (ShopInfo) applicationContext.getBean("shopInfo");
        //System.out.println(shopInfo);

        //演示在Spring中配置Action、Service等Bean
        shopInfoService.buy(BigInteger.valueOf(1L), "java");
        return SUCCESS;
    }
}
