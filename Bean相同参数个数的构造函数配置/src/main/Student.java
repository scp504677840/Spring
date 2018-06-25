package main;

public class Student {

    private String name;
    private int age;
    private double height;

    /**
     * 为了演示spring配置中的IOC的type作用，这里书写两个构造函数，就是第二个参数不同。
     *
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        System.out.println("student spring ioc");
        this.name = name;
        this.age = age;
    }

    /**
     * 为了演示spring配置中的IOC的type作用，这里书写两个构造函数，就是第二个参数不同。
     *
     * @param name
     * @param height
     */
    public Student(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
