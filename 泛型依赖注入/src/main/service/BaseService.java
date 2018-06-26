package main.service;

import main.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    protected void pl() {
        System.out.println("call pl: " + repository);
    }

}
