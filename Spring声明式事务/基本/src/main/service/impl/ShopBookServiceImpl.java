package main.service.impl;

import main.repository.ShopBookRepository;
import main.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shopBookService")
public class ShopBookServiceImpl implements ShopBookService {

    @Autowired
    private ShopBookRepository shopBookRepository;

}
