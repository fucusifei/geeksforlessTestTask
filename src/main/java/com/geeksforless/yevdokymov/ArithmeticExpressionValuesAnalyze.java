package com.geeksforless.yevdokymov;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionValuesAnalyze - клас для аналізу строки та заповнення списку об'єктів типу ArithmeticExpressionValues
 */
public class ArithmeticExpressionValuesAnalyze {
    public ArrayList<ArithmeticExpressionValues> values = new ArrayList<>();
    public  List<ArithmeticExpressionValues> analyze(StringBuilder arithmeticExpression) {

        int positionChecker = 0;
        while (positionChecker < arithmeticExpression.length()) {
            char c = arithmeticExpression.charAt(positionChecker);
            switch (c) {
                case '+':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.PLUS, c));
                    positionChecker++;
                    continue;
                case '-':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MINUS, c));
                    positionChecker++;
                    continue;
                case '*':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MULTIPLY, c));
                    positionChecker++;
                    continue;
                case '/':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.DIVIDE, c));
                    positionChecker++;
                    continue;
                case '(':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.LEFT_PARENTHESIS, c));
                    positionChecker++;
                    continue;
                case ')':
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.RIGHT_PARENTHESIS, c));
                    positionChecker++;
                    continue;
                default:
                    if ('0' <= c && c <= '9') {
                        StringBuilder fullNumber = new StringBuilder();
                        do {
                            fullNumber.append(c);
                            positionChecker++;

                            if (positionChecker >= arithmeticExpression.length()) {
                                break;
                            }
                            else {
                                c = arithmeticExpression.charAt(positionChecker);
                            }
                        }
                        while ('0' <= c && c <= '9');
                        values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.NUMBER, fullNumber.toString()));
                    }
                    else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character:" + c);
                        }
                        positionChecker++;
                    }
            }
        }
        values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.EOF, ""));
        return values;
    }
}
