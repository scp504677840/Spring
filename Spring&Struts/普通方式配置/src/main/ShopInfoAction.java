package main;

import com.opensymphony.xwork2.ActionSupport;
import main.entities.ShopInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

public class ShopInfoAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ApplicationContext applicationContext = (ApplicationContext) ServletActionContext.getServletContext().getAttribute("ApplicationContext");
        ShopInfo shopInfo = (ShopInfo) applicationContext.getBean("shopInfo");
        System.out.println(shopInfo);
        return SUCCESS;
    }
}
