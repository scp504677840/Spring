package main.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Hero {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String name;

    public Hero() {
    }

    public Hero(Timestamp gmtCreate, Timestamp gmtModified, String name) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.name = name;
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

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                '}';
    }
}
