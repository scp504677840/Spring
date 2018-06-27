package main.repository.impl;

import main.entities.BookInfo;
import main.exceptions.BookInfoException;
import main.exceptions.QueryException;
import main.repository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("bookInfoRepository")
public class BookInfoRepositoryImpl implements BookInfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据书籍名称查询书籍信息
     *
     * @param bookName 书籍名称
     * @return 书籍信息
     */
    @Override
    public BookInfo getBookByName(String bookName) {
        String sql = "select id, gmt_create gmtCreate, gmt_modified gmtModified, name, price from book_info where name = ?";
        RowMapper<BookInfo> rowMapper = new BeanPropertyRowMapper<>(BookInfo.class);
        Object[] args = new Object[]{bookName};
        BookInfo bookInfo;
        try {
            bookInfo = jdbcTemplate.queryForObject(sql, rowMapper, args);
        } catch (DataAccessException e) {
            throw new BookInfoException(e);
        }
        return bookInfo;
    }
}
