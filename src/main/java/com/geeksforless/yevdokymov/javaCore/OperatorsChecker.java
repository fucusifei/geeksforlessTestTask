package com.geeksforless.yevdokymov.javaCore;

import com.geeksforless.yevdokymov.exсeption.OperatorsCheckerException;

import java.util.ArrayList;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс OperatorsChecker - клас, який перевіряє коректність розставлення операторів у арифметичному виразі
 */
public class OperatorsChecker {
    public  void OperatorsCheckerAnalyze(ArrayList<ArithmeticExpressionValues> values) throws OperatorsCheckerException {
        // для перевірки першого елементу списку
        if (values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.DIVIDE ||
                values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MULTIPLY ||
                    values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.PLUS ) {
            throw new OperatorsCheckerException("wrong operator placement");
        }
        // для перевірки елементів списку на відсутність операторів поруч
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS) {
                if (values.get(i - 1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS)
                    throw new OperatorsCheckerException("wrong operator placement");
            }
        }
    }
}
