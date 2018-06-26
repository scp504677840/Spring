package main.dao.impl;

import main.dao.BookRepository;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {
    @Override
    public void save() {
        System.out.println("BookRepositoryImpl save");
    }
}
