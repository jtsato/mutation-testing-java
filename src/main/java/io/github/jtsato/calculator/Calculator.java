package io.github.jtsato.calculator;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int[] divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int[] result = new int[2];
        result[0] = dividend / divisor; // Quotient
        result[1] = dividend % divisor; // Remainder
        return result;
    }
}
