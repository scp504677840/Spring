package main.service.impl;

import main.repository.BookStockRepository;
import main.service.BookStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookStockService")
public class BookStockServiceImpl implements BookStockService {

    @Autowired
    private BookStockRepository bookStockRepository;

}
