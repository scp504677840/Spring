package main.repository;

import main.entities.BookStock;
import main.exceptions.QueryException;
import main.exceptions.UpdateException;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface BookStockRepository {
    /**
     * 根据书籍ID查询书籍库存
     *
     * @param bookId 书籍ID
     * @return 书籍库存
     */
    BookStock getStockByBookId(BigInteger bookId);

    /**
     * 根据书籍Id更新书籍库存
     *
     * @param bookId 书籍Id
     * @param stock  书籍库存
     * @return 是否更新成功
     */
    Boolean updateStockByBookId(BigInteger bookId, Integer stock);
}
