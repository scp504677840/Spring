package main.service.impl;

import main.entities.Book;
import main.service.BaseService;
import main.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl extends BaseService<Book> implements BookService {

    @Override
    public void save() {
        pl();
        System.out.println("BookServiceImpl save");
    }
}
