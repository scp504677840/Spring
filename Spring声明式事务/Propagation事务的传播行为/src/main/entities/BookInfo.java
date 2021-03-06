package main.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * -- auto-generated definition
 * create table book_info
 * (
 *   id           bigint unsigned auto_increment,
 *   gmt_create   datetime       not null,
 *   gmt_modified datetime       not null,
 *   name         varchar(30)    not null,
 *   price        decimal(10, 2) not null,
 *   constraint book_id_uindex
 *   unique (id)
 * );
 *
 * alter table book_info
 *   add primary key (id);
 */
public class BookInfo {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String name;
    private BigDecimal price;

    public BookInfo() {
    }

    public BookInfo(Timestamp gmtCreate, Timestamp gmtModified, String name, BigDecimal price) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}