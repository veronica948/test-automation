package com.haritonova.calculator.runner;

import com.haritonova.calculator.logic.Calculator;
import java.util.Scanner;

/**
 * @author Veronica_Haritonova
 */
public class Runner {

    private static final String ADDITION_SIGN = "+";
    private static final String MULTIPLICATION_SIGN = "*";
    private static final String DIVISION_SIGN = "/";
    private static final String SUBTRACTION_SIGN = "-";

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String operationSign = null;
            Integer x = null;
            Integer y = null;
            String pattern = "[+|\\-|*|/]";
            boolean isWrong = true;
            sc.useDelimiter(" ");
            String xValue = null;
            String yValue = null;
            System.out.println("Input expression");
                xValue = sc.findInLine("[0-9]*");
                operationSign = sc.findInLine(pattern);
                yValue = sc.findInLine("[0-9]*");
                if(xValue != null && yValue != null && operationSign != null) {
                    x = Integer.valueOf(xValue);
                    y = Integer.valueOf(yValue);
                    Integer result = null;
                    Double divisionResult = null;
                    switch (operationSign) {
                        case MULTIPLICATION_SIGN : result = Calculator.multiply(x, y);
                            break;
                        case ADDITION_SIGN : result = Calculator.add(x,y);
                            break;
                        case DIVISION_SIGN : divisionResult = Calculator.divide(x,y);
                            break;
                        case SUBTRACTION_SIGN : result = Calculator.subtract(x,y);
                            break;
                    }
                    if(result != null) {
                        System.out.println("Result = " + result);
                    }
                    if(divisionResult != null) {
                        System.out.println("Result = " +  divisionResult);
                    }

                } else {
                    System.out.println("Incorrect operation");
                }

            }
    }
}
