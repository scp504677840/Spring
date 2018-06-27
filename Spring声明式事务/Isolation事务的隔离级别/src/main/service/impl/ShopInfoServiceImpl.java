package main.service.impl;

import main.entities.BookInfo;
import main.entities.BookStock;
import main.exceptions.QueryException;
import main.exceptions.UpdateException;
import main.repository.*;
import main.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {

    /**
     * 店铺信息数据访问层
     */
    @Autowired
    private ShopInfoRepository shopInfoRepository;

    /**
     * 店铺书籍数据访问层
     */
    @Autowired
    private ShopBookRepository shopBookRepository;

    /**
     * 书籍数据访问层
     */
    @Autowired
    private BookInfoRepository bookInfoRepository;

    /**
     * 书籍库存数据访问层
     */
    @Autowired
    private BookStockRepository bookStockRepository;

    /**
     * 账户数据访问层
     */
    @Autowired
    private AccountInfoRepository accountInfoRepository;

    /**
     * 购买书籍
     * 1.添加事务注解@Transactional
     *
     * 事务的传播行为：
     * 使用@Transactional注解里的propagation属性。
     * 常用的属性值：
     * 1.Propagation.REQUIRED：如果调用我的方法已经开启了事务，那么就沿用它的事务。
     * 2.Propagation.REQUIRES_NEW：如果调用我的方法已经开启了事务，即使它开启了事务，我也要新开启一个事务，来执行我自己方法里的逻辑。
     * 应用场景：
     * 客户Tom账户有100元，购物车里有两本书，一本java，单件60，一本go，单价50。
     * 选中这两本书，一起下单，也就是一共110元。
     * 从Web前端远程调用如下方法：
     * //外面的方法开启事务
     * @Transactional
     * public void batchBuy(){
     *     //ShopInfoServiceImpl$buy()
     *     buy(1,"java");
     *     buy(1,"go");
     * }
     * 注意：
     * 1.外面的batchBuy开启了事务。它里面调用的ShopInfoServiceImpl$buy方法也使用了声明式事务注解。
     * 2.现在有两个方法同时添加了声明式事务注解，并且还是一个方法调用另外一个方法。事务怎么算？
     * 3.如果统一使用外面batchBuy方法的事务，那么整个购买过程会因余额不足而导致事务回滚，购买失败。
     * 4.如果外面batchBuy方法和里面buy方法分别启用各自的事务，
     * 那么整个购买过程的结果会是先买的第一本成功，
     * 后买的第二本会因余额不足而导致buy方法事务回滚，购买失败。
     * 然而外面的batchBuy方法整个事务是好的。
     * 5.上面说的情况3属于@Transactional(propagation = Propagation.REQUIRES)，情况4属于@Transactional(propagation = Propagation.REQUIRES_NEW)。
     * 6.声明式事务注解@Transactional默认的propagation为Propagation.REQUIRES。
     *
     * ---------------------------------------------------------------
     * 事务的隔离级别
     * 1.Spring声明式事务的隔离级别有哪几种？
     * DEFAULT(-1) 默认
     * READ_UNCOMMITTED(1) 读未提交
     * READ_COMMITTED(2) 读已提交
     * REPEATABLE_READ(4) 可重复读
     * SERIALIZABLE(8) 序列化
     * 2.如何设置Spring声明式事务隔离级别？
     * 设置@Transactional的isolation属性
     * 例如：@Transactional(isolation = Isolation.READ_COMMITTED)
     *
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    @Override
    public void buy(BigInteger accountId, String bookName) {
        //1.查询书籍信息
        BookInfo bookInfo = bookInfoRepository.getBookByName(bookName);
        System.out.println(bookInfo);
        if (bookInfo == null) {
            System.out.println("书籍不存在！！！");
            return;
        }

        //2.查询书籍库存
        BookStock bookStock = bookStockRepository.getStockByBookId(bookInfo.getId());
        System.out.println(bookStock);
        if (bookStock == null || bookStock.getStock().compareTo(0) < 0) {
            System.out.println("书籍无库存！！！");
            return;
        }

        //3.查询账户余额
        BigDecimal balance = accountInfoRepository.getAccountBalanceByAccountId(accountId);
        System.out.println("balance: " + balance);
        if (balance == null) {
            System.out.println("账户不存在！！！");
            return;
        }

        //4.检查账户余额是否能购买
        if (balance.compareTo(bookInfo.getPrice()) < 0) {
            System.out.println("余额不足！！！");
            return;
        }

        //设置新库存
        bookStock.setStock(bookStock.getStock() - 1);
        //新余额 = 原余额 - 书籍价格
        balance = balance.subtract(bookInfo.getPrice());

        //5.书籍减库存
        Boolean update = bookStockRepository.updateStockByBookId(bookInfo.getId(), bookStock.getStock());
        System.out.println("update: " + update);

        //6.账户减余额
        update = accountInfoRepository.updateBalanceByAccountId(accountId, balance);
        System.out.println("update balance: " + update);
    }
}
