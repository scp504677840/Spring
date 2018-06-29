package main.repository.impl;

import main.entities.ShopInfoEntity;
import main.repository.ShopInfoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.List;

public class ShopInfoRepositoryImpl implements ShopInfoRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取Session
     *
     * Spring 和 Hibernate 事务的流程
     * 1.在方法开始之前
     * ①获取session
     * ②把session和当前线程绑定，这样就可以在 Repository 中使用SessionFactory的getCurrentSession()方法来获取session。
     * ③开启事务
     *
     * 2.若方法正常结束，即没有出现异常，则
     * ①提交事务
     * ②使和当前线程绑定的session解除绑定
     * ③关闭session
     *
     * 3.若方法出现异常，则
     * ①回滚事务
     * ②使和当前线程绑定的session解除绑定
     * ③关闭session
     *
     * @return Session
     */
    private Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * 根据店铺Id查询店铺信息
     *
     * @param shopInfoId 店铺Id
     * @return 店铺信息
     */
    @Override
    public ShopInfoEntity getShopInfoById(BigInteger shopInfoId) {
        String sql = "from ShopInfoEntity where id = :id";
        Query<ShopInfoEntity> query = getSession().createQuery(sql, ShopInfoEntity.class);
        query.setParameter("id", shopInfoId);
        List<ShopInfoEntity> shopInfos = query.list();
        return shopInfos.get(0);
    }
}
