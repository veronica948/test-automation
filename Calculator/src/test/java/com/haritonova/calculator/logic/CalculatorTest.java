package com.haritonova.calculator.logic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void addPositiveNumbers() {
        int actual = Calculator.add(11,22);
        int expected = 33;
        assertEquals("Incorrect sum of two positive numbers",expected,actual);
    }
    @Test
    public void addNegativeAndPositiveNumbers() {
        int actual = Calculator.add(-11,22);
        int expected = 11;
        assertEquals("Incorrect sum of two numbers with different signs",expected,actual);
    }
    @Test
    public void addNegativeNumbers() {
        int actual = Calculator.add(-11,-10);
        int expected = -21;
        assertEquals("Incorrect sum of two negative numbers",expected,actual);
    }
    @Test
    public void subtractPositiveNumbers() {
        int actual = Calculator.subtract(11, 22);
        int expected = -11;
        assertEquals("Incorrect difference of two positive numbers",expected,actual);
    }
    @Test
    public void subtractNegativeNumbers() {
        int actual = Calculator.subtract(-11,-22);
        int expected = 11;
        assertEquals("Incorrect difference of two negative numbers",expected,actual);
    }
    @Test
    public void multiplyPositiveNumbers() {
        int actual = Calculator.multiply(11, 3);
        int expected = 33;
        assertEquals("Incorrect product of two positive numbers",expected,actual);
    }
    @Test
    public void multiplyNegativeNumbers() {
        int actual = Calculator.multiply(-3, -2);
        int expected = 6;
        assertEquals("Incorrect product of two negative numbers",expected,actual);
    }
    @Test
    public void multiplyPositiveAndNegativeNumbers() {
        int actual = Calculator.multiply(3,-2);
        int expected = -6;
        assertEquals("Incorrect product of two numbers with different signs",expected,actual);
    }
    @Test
    public void dividePositiveNumbers() {
        double actual = Calculator.divide(8, 2);
        double expected = 4;
        double eps = 0.0000001;
        assertEquals("Incorrect quotient of two positive numbers",expected,actual,eps);
    }
    @Test
    public void divideNegativeNumbers() {
        double actual = Calculator.divide(-3, -2);
        double expected = 1.5;
        double eps = 0.0000001;
        assertEquals("Incorrect quotient of two negative numbers",expected,actual,eps);
    }
    @Test
    public void divideByZero() {
        double actual = Calculator.divide(3,0);
        double expected = Double.POSITIVE_INFINITY;
        double eps = 0.0000001;
        assertEquals("Incorrect quotient when dividing by zero",expected,actual,eps);
    }
}
