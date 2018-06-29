package main.repository;

import main.entities.ShopInfoEntity;

import java.math.BigInteger;

public interface ShopInfoRepository {

    /**
     * 根据店铺Id查询店铺信息
     *
     * @param shopInfoId 店铺Id
     * @return 店铺信息
     */
    ShopInfoEntity getShopInfoById(BigInteger shopInfoId);
}
