package main;

import main.controller.BookController;
import main.repository.BookRepository;
import main.service.BookService;
import main.entities.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC & DI
 * <p>
 * 1.ApplicationContext：面向开发者【开发使用】
 * 2.BeanFactory：面向spring
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        BookController bookController = (BookController) ctx.getBean("bookController");
        bookController.execute();

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

        BookRepository bookDao = (BookRepository) ctx.getBean("bookRepository");
        bookDao.save();

        Book book = (Book) ctx.getBean("book");
        System.out.println(book);

    }

}
