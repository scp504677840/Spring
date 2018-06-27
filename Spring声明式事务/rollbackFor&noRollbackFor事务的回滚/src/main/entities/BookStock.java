package main.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * -- auto-generated definition
 * create table book_stock
 * (
 *   id           bigint unsigned auto_increment,
 *   gmt_create   datetime        not null,
 *   gmt_modified datetime        not null,
 *   stock        int unsigned    not null,
 *   book_id      bigint unsigned not null,
 *   constraint book_stock_book_id_uindex
 *   unique (book_id),
 *   constraint book_stock_id_uindex
 *   unique (id)
 * );
 *
 * alter table book_stock
 *   add primary key (id);
 */
public class BookStock {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer stock;
    private BigInteger bookId;

    public BookStock() {
    }

    public BookStock(Timestamp gmtCreate, Timestamp gmtModified, Integer stock, BigInteger bookId) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.stock = stock;
        this.bookId = bookId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigInteger getBookId() {
        return bookId;
    }

    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookStock{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", stock=" + stock +
                ", bookId=" + bookId +
                '}';
    }
}
