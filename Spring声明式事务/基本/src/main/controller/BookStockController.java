package main.controller;

import main.service.BookStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("bookStockController")
public class BookStockController {

    @Autowired
    private BookStockService bookStockService;

}
