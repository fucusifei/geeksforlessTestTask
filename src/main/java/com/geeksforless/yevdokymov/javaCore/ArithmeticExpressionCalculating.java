package com.geeksforless.yevdokymov.javaCore;

import java.util.ArrayList;
import java.util.Stack;

public class ArithmeticExpressionCalculating {
    private final Stack<String> stackNumber = new Stack<>();
    private final Stack<String> stackOperator = new Stack<>();
    public Double calculate (ArrayList<ArithmeticExpressionValues> values) {
        int priority;
        for (ArithmeticExpressionValues value : values) {
            priority = getPriority(value.getValue());

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

        public int getPriority (String value) {
            return switch (value) {
                case "(" -> 1;
                case ")" -> -1;
                case "+", "-" -> 2;
                case "*", "/" -> 3;
                default -> 0;
            };
        }
        public void calculateHelper (String operator) {
            switch (operator) {
                case "+" -> stackNumber.push(String.valueOf(Double.parseDouble(stackNumber.pop()) + Double.parseDouble(stackNumber.pop())));
                case "-" -> stackNumber.push(String.valueOf(- Double.parseDouble(stackNumber.pop()) + Double.parseDouble(stackNumber.pop())));
                case "*" -> stackNumber.push(String.valueOf(Double.parseDouble(stackNumber.pop()) * Double.parseDouble(stackNumber.pop())));
                case "/" -> stackNumber.push(String.valueOf(1 / Double.parseDouble(stackNumber.pop()) * Double.parseDouble(stackNumber.pop())));
            }
        }
}
