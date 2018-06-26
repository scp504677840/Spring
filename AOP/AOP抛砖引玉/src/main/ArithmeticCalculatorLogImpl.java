package main;

public class ArithmeticCalculatorLogImpl implements ArithmeticCalculator {
    @Override
    public double add(double x, double y) {
        System.out.println("Main add before");
        double result = x + y;
        System.out.println("Main add after");
        return result;
    }

    @Override
    public double subtract(double x, double y) {
        System.out.println("Main subtract before");
        double result = x - y;
        System.out.println("Main subtract after");
        return result;
    }

    @Override
    public double multiply(double x, double y) {
        System.out.println("Main multiply before");
        double result = x * y;
        System.out.println("Main multiply after");
        return result;
    }

    @Override
    public double divide(double x, double y) {
        System.out.println("Main divide before");
        double result = x / y;
        System.out.println("Main divide after");
        return result;
    }
}
