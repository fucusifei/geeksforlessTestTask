package com.geeksforless.yevdokymov.javaCore;

import com.geeksforless.yevdokymov.exeption.UnexpectedCharacterException;


import java.util.ArrayList;
import java.util.List;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionValuesAnalyze - клас для аналізу строки та заповнення списку об'єктів типу ArithmeticExpressionValues
 */
public class ArithmeticExpressionValuesAnalyze {
    public ArrayList<ArithmeticExpressionValues> values = new ArrayList<>();
    public  List<ArithmeticExpressionValues> analyze(StringBuilder arithmeticExpression) throws UnexpectedCharacterException{

        int positionChecker = 0;
        while (positionChecker < arithmeticExpression.length()) {
            char c = arithmeticExpression.charAt(positionChecker);


            switch (c) {
                case '+' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.PLUS, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS));
                    positionChecker++;
                }
                case '-' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MINUS, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS));
                    positionChecker++;
                }
                case '*' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MULTIPLY, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS));
                    positionChecker++;
                }
                case '/' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.DIVIDE, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS));
                    positionChecker++;
                }
                case '(' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.LEFT_PARENTHESIS, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.PARENTHESIS));
                    positionChecker++;
                }
                case ')' -> {
                    values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.RIGHT_PARENTHESIS, c, ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.PARENTHESIS));
                    positionChecker++;
                }
                default -> {
                    if ('0' <= c && c <= '9') {
                        StringBuilder fullNumber = new StringBuilder();
                        while ('0' <= c && c <= '9'){
                            fullNumber.append(c);
                            positionChecker++;

                            if (positionChecker >= arithmeticExpression.length()) {
                                break;
                            } else {
                                c = arithmeticExpression.charAt(positionChecker);
                            }

                        }
                            values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.NUMBER, fullNumber.toString(), ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.NUMBERS));

                    }
                    else if (c != ' ') throw new UnexpectedCharacterException("unexpected character", c);
                    else if (c == ' ') {
                        positionChecker++;
                    }

                }
            }
        }
        values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.EOF, "", ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.EOF));
        return values;
    }
}
