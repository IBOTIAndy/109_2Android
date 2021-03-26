package com.bot.t105590006_hw;


/**
 * Utility class for SimpleCalc to perform the actual calculations.
 */
public class Calculator {

    // Available operations
    public enum Operator {ADD, SUB, DIV, MUL, POW}

    /**
     * Addition operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtract operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divide operation
     */
    public double div(double firstOperand, double secondOperand) {
        if (secondOperand == 0 ) {
            throw new IllegalArgumentException("You cannot divide by zero");
        }
        return firstOperand / secondOperand;
    }

    /**
     * Multiply operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double pow(double firstOperand, double secondOperand) {
        return java.lang.Math.pow(firstOperand, secondOperand);
    //    if(secondOperand == 0){
    //        return 1;
    //    }
    //    return pow(firstOperand, secondOperand - 1) * firstOperand;
    }
}