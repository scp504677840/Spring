package main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseRepository<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
