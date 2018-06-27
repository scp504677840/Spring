package main.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

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
