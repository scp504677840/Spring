package main.entities;

public class ShopInfo {
    private String name;

    public ShopInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
