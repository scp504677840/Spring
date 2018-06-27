package main.repository;

import main.entities.BookInfo;

public interface BookInfoRepository {

    /**
     * 根据书籍名称查询书籍信息
     *
     * @param bookName 书籍名称
     * @return 书籍信息
     */
    BookInfo getBookByName(String bookName);
}
