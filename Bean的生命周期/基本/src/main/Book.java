package main;

public class Book {
    private String name;
    private double price;

    public Book() {
        System.out.println("call构造函数");
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void init() {
        System.out.println("call init");
    }

    public void destroy() {
        System.out.println("call destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("call setName");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("call setPrice");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
