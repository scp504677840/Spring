package main.service.impl;

import main.entities.ShopInfoEntity;
import main.repository.ShopInfoRepository;
import main.service.ShopInfoService;

import java.math.BigInteger;

public class ShopInfoServiceImpl implements ShopInfoService {

    private ShopInfoRepository shopInfoRepository;

    public void setShopInfoRepository(ShopInfoRepository shopInfoRepository) {
        this.shopInfoRepository = shopInfoRepository;
    }

    /**
     * 购买书籍
     *
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    @Override
    public void buy(BigInteger accountId, String bookName) {
        ShopInfoEntity shopInfoEntity  = shopInfoRepository.getShopInfoById(BigInteger.valueOf(1L));
        System.out.println(shopInfoEntity);
    }
}
