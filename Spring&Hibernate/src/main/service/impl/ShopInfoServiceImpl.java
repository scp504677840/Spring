package main.service.impl;

import main.entities.ShopInfoEntity;
import main.repository.ShopInfoRepository;
import main.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {

    @Autowired
    private ShopInfoRepository shopInfoRepository;

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
