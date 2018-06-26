package main;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法
 */
public class BookBeanFactory {

    private static Map<String, Book> books = new HashMap<>();

    static {
        books.put("java", new Book("java", 11.55));
        books.put("go", new Book("go", 22.55));
        books.put("python", new Book("python", 33.55));
    }

    /**
     * 获取Book实例
     *
     * @param name Book名称
     * @return Book名称对应的Bean实例
     */
    public static Book getBook(String name) {
        return books.get(name);
    }

}
