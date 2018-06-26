package main.controller;

import main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    /**
     * 业务逻辑层
     */
    @Autowired
    protected BookService bookService;

    public void execute(){
        bookService.save();
        System.out.println("BookController execute");
    }

}
