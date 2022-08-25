package com.geeksforless.yevdokymov.javaCore;

import com.geeksforless.yevdokymov.exсeption.ParenthesisCheckerException;

import java.util.ArrayList;

/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ParenthesisChecker - клас для аналізу списку для перевірки правильності розстановки скобок
 */
public class ParenthesisChecker {
    public int parenthesisChecker = 0;
    /**
     * Метод аналізу строки у StringBuilder та запису посимвольно у список як об'єкт типу ArithmeticExpressionValues
     *
     * @param values список об'єктів типу ArithmeticExpressionValues, з значеннями та типами елементів введеного арифметичного виразу
     */
    public  void ParenthesisCheckerAnalyze(ArrayList<ArithmeticExpressionValues> values) throws ParenthesisCheckerException {
        // перевірка першого елементу списку на тип LEFT_PARENTHESIS та відсутність після нього будь-якого оператора крім мінуса
        if (values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.LEFT_PARENTHESIS) {
            if ( values.get(1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS
                    && values.get(1).getType() != ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MINUS)
                throw new ParenthesisCheckerException("wrong parentheses placement");
            else {
                parenthesisChecker++;
            }
        }
        // перевірка першого елементу списку на тип RIGHT_PARENTHESIS, якщо True викидується ParenthesisCheckerException
        else if (values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.RIGHT_PARENTHESIS)
            throw new ParenthesisCheckerException("wrong parentheses placement");

        // проходження по списку, для перевірки правильность розстановки дужок,
        // для лівої дужки неможлива наявність оператора справа або числа зліва
        // дял правої дужки неможлива наявність оператора зліва або числа справа
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.LEFT_PARENTHESIS) {
                if (values.get(i - 1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.NUMBERS
                        || values.get(i + 1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS
                            && values.get(i + 1).getType() != ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MINUS)
                            throw new ParenthesisCheckerException("wrong parentheses placement");
                else {
                    parenthesisChecker++;
                }
            }
            else if (values.get(i).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.RIGHT_PARENTHESIS) {

                    if (values.get(i - 1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS
                            || values.get(i + 1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.NUMBERS)
                                throw new ParenthesisCheckerException("wrong parentheses placement");
                    else {
                        parenthesisChecker--;
                        if (parenthesisChecker < 0) throw new ParenthesisCheckerException("wrong parentheses placement");
                    }
            }
        }
        if (parenthesisChecker != 0) throw new ParenthesisCheckerException("wrong parentheses placement");

    }

}
