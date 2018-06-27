package main.service.impl;

import main.entities.BookInfo;
import main.entities.BookStock;
import main.exceptions.QueryException;
import main.exceptions.UpdateException;
import main.repository.*;
import main.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
     * @param accountId 账户Id
     * @param bookName  书籍名称
     */
    @Transactional
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
