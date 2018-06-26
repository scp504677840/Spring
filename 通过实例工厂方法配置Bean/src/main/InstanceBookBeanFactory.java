package main;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法
 */
public class InstanceBookBeanFactory {

    private Map<String, Book> books;

    public InstanceBookBeanFactory() {
        books = new HashMap<>();
        books.put("java", new Book("java", 11.11));
        books.put("go", new Book("go", 22.22));
        books.put("python", new Book("python", 33.33));
    }

    public Book getBook(String name) {
        return books.get(name);
    }
}
