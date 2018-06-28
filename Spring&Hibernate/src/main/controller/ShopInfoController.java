package main.controller;

import main.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;

@Controller
public class ShopInfoController {

    @Autowired
    private ShopInfoService shopInfoService;

    /**
     * 购买书籍
     *
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    public void buy(BigInteger accountId, String bookName) {
        shopInfoService.buy(accountId,bookName);
    }
}
