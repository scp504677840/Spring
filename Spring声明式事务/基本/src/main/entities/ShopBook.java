package main.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * -- auto-generated definition
 * create table shop_book
 * (
 *   id           bigint unsigned auto_increment,
 *   gmt_create   datetime        not null,
 *   gmt_modified datetime        not null,
 *   shop_id      bigint unsigned not null,
 *   book_id      bigint unsigned not null,
 *   constraint shop_book_id_uindex
 *   unique (id)
 * );
 *
 * alter table shop_book
 *   add primary key (id);
 */
public class ShopBook {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private BigInteger shopId;
    private BigInteger bookId;

    public ShopBook() {
    }

    public ShopBook(Timestamp gmtCreate, Timestamp gmtModified, BigInteger shopId, BigInteger bookId) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.shopId = shopId;
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

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public BigInteger getBookId() {
        return bookId;
    }

    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "ShopBook{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", shopId=" + shopId +
                ", bookId=" + bookId +
                '}';
    }
}
