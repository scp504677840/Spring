package main.service.impl;

import main.service.ShopInfoService;

import java.math.BigInteger;

public class ShopInfoServiceImpl implements ShopInfoService {

    /**
     * 购买书籍
     *
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    @Override
    public void buy(BigInteger accountId, String bookName) {
        System.out.println("ShopInfoServiceImpl");
    }

}
