package main.repository.impl;

import main.entities.Book;
import main.repository.BaseRepository;
import main.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public class BookRepositoryImpl extends BaseRepository<Book> implements BookRepository {
    @Override
    public void save() {
        System.out.println("BookRepositoryImpl save");
    }
}
