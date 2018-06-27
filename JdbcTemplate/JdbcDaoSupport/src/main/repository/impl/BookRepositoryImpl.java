package main.repository.impl;

import main.entities.Book;
import main.repository.BaseRepository;
import main.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

@Repository("bookRepository")
public class BookRepositoryImpl extends BaseRepository<Book> implements BookRepository {
    @Override
    public void save() {
        String sql = "insert into hero (gmt_create, gmt_modified, name) values (?,?,?)";
        getJdbcTemplate().update(sql, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
        System.out.println("BookRepositoryImpl save");
    }
}
