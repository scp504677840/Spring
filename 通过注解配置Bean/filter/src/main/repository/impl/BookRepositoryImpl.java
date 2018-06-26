package main.repository.impl;

import main.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {
    @Override
    public void save() {
        System.out.println("BookRepositoryImpl save");
    }
}
