package main.controller;

import main.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("bookInfoController")
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

}
