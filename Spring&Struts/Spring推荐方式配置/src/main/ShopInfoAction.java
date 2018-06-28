package main;

import com.opensymphony.xwork2.ActionSupport;
import main.entities.ShopInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ShopInfoAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        ShopInfo shopInfo = (ShopInfo) applicationContext.getBean("shopInfo");
        System.out.println(shopInfo);
        return SUCCESS;
    }
}
