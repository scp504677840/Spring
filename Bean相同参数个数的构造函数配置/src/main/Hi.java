package main;

public class Hi {

    private String name;

    public Hi() {
        System.out.println("hi spring ioc");
    }

    public void Hi() {
        System.out.println("Hi!!!" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
