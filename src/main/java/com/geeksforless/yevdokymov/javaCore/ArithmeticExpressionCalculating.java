package com.geeksforless.yevdokymov.javaCore;

import java.util.ArrayList;
import java.util.Stack;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionCalculating - клас для вирішення арифметичного виразу
 */
public class ArithmeticExpressionCalculating {
    /**Стек для збереження чисел*/
    private final Stack<String> stackNumber = new Stack<>();
    /**Стек для збереження операторів*/
    private final Stack<String> stackOperator = new Stack<>();
    /**
     * Метод для вирішення арифметичного виразу
     *
     * @param values  арифметичний вираз, збережений у вигляди списту об'єктів типу ArithmeticExpressionValues
     */
    public Double calculate (ArrayList<ArithmeticExpressionValues> values) {
        int priority;
        // проходження по кожному символу списку
        for (ArithmeticExpressionValues value : values) {
            priority = getPriority(value.getValue());
            // перевірка символів спису та запис у відповідний стек
            switch (priority) {
                case 0 -> stackNumber.push(value.getValue());
                case 1 -> stackOperator.push(value.getValue());
                case 2 -> {
                    if (!stackOperator.empty()) {
                        while (!stackOperator.empty()) {
                            if (getPriority(stackOperator.peek()) >= priority) {
                                calculateHelper(stackOperator.peek());
                                stackOperator.pop();
                            }
                        }
                    }
                    stackOperator.push(value.getValue());
                }
                case 3 -> {
                    if (!stackOperator.empty()) {
                        if (getPriority(stackOperator.peek()) == priority) {
                            calculateHelper(stackOperator.peek());
                            stackOperator.pop();
                        }
                    }
                    stackOperator.push(value.getValue());
                }
                case -1 -> {
                    while (!stackOperator.peek().equals("(")) {
                        calculateHelper(stackOperator.peek());
                        stackOperator.pop();
                    }
                    stackOperator.pop();
                }
            }
        }
        stackNumber.pop();
        while (!stackOperator.empty()) {
            calculateHelper(stackOperator.peek());
            stackOperator.pop();
        }
       return Double.parseDouble(stackNumber.pop());
    }
    /**
     * Метод аналізу пріорітетів операторів
     *
     * @param value знайдений у списку символ
     */
        public int getPriority (String value) {
            return switch (value) {
                case "(" -> 1;
                case ")" -> -1;
                case "+", "-" -> 2;
                case "*", "/" -> 3;
                default -> 0;
            };
        }
    /**
     * Метод для підрахування простих виразів
     *
     * @param operator необхідний для виразу оператор
     */
        public void calculateHelper (String operator) {
            switch (operator) {
                case "+" -> stackNumber.push(String.valueOf(Double.parseDouble(stackNumber.pop()) + Double.parseDouble(stackNumber.pop())));
                case "-" -> stackNumber.push(String.valueOf(- Double.parseDouble(stackNumber.pop()) + Double.parseDouble(stackNumber.pop())));
                case "*" -> stackNumber.push(String.valueOf(Double.parseDouble(stackNumber.pop()) * Double.parseDouble(stackNumber.pop())));
                case "/" -> stackNumber.push(String.valueOf(1 / Double.parseDouble(stackNumber.pop()) * Double.parseDouble(stackNumber.pop())));
            }
        }
}
