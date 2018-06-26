package main;

public class Address {

    private String city;
    private String street;

    public Address() {
        System.out.println("address : call 构造函数");
    }

    public void init(){
        System.out.println("address : call init");
    }

    public void destroy(){
        System.out.println("address : call destroy");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        System.out.println("address : call setCity");
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        System.out.println("address : call setStreet");
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
