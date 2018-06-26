package main;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        return x / y;
    }
}
