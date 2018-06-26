package main;

import org.springframework.beans.factory.FactoryBean;

public class BookFactoryBean implements FactoryBean<Book> {

    private String name;
    private double price;

    /**
     * 获取Bean的实例
     * 1.可以直接使用无参构造方法
     * 2.【可选】你也可以通过设置此类中的一个属性来设置Bean的有参构造方法
     *
     * @return Bean的实例
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        //1.直接使用无参的构造函数
        //return new Book();

        //2.【可选】使用带参的构造函数
        return new Book(name, price);
    }

    /**
     * 设置Bean的Class
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是否为单例
     * 一般我们可以设置为true
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
