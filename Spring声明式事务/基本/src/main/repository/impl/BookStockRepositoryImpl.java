package main.repository.impl;

import main.entities.BookStock;
import main.exceptions.BookStockException;
import main.exceptions.BookStockUpdateException;
import main.exceptions.QueryException;
import main.exceptions.UpdateException;
import main.repository.BookStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository("bookStockRepository")
public class BookStockRepositoryImpl implements BookStockRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据书籍ID查询书籍库存
     *
     * @param bookId 书籍ID
     * @return 书籍库存
     */
    @Override
    public BookStock getStockByBookId(BigInteger bookId) {
        String sql = "select id, gmt_create gmtCreate, gmt_modified gmtModified, stock, book_id bookId from book_stock where book_id = ?";
        RowMapper<BookStock> rowMapper = new BeanPropertyRowMapper<>(BookStock.class);
        Object[] args = new Object[]{bookId};
        BookStock bookStock;
        try {
            bookStock = jdbcTemplate.queryForObject(sql, rowMapper, args);
        } catch (DataAccessException e) {
            throw new BookStockException(e);
        }
        return bookStock;
    }

    /**
     * 根据书籍Id更新书籍库存
     *
     * @param bookId 书籍Id
     * @param stock  书籍库存
     * @return 是否更新成功
     */
    @Override
    public Boolean updateStockByBookId(BigInteger bookId, Integer stock) {
        String sql = "update book_stock set stock = ? where book_id = ?";
        Object[] args = new Object[]{stock, bookId};
        try {
            int count = jdbcTemplate.update(sql, args);
            if (count > 0) {
                return Boolean.TRUE;
            }
        } catch (DataAccessException e) {
            throw new BookStockUpdateException(e);
        }
        return Boolean.FALSE;
    }
}
