package main.service;

import java.math.BigInteger;

public interface ShopInfoService {

    /**
     * 购买书籍
     *
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    void buy(BigInteger accountId, String bookName);

}
