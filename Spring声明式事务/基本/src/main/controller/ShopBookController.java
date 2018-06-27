package main.controller;

import main.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("shopBookController")
public class ShopBookController {

    @Autowired
    private ShopBookService shopBookService;

}
