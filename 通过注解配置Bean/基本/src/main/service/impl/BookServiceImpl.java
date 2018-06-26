package main.service.impl;

import main.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("BookServiceImpl save");
    }
}
