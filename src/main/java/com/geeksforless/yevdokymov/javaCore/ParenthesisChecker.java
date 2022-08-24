package com.geeksforless.yevdokymov.javaCore;

import com.geeksforless.yevdokymov.exeption.ParenthesisCheckerException;

import java.util.ArrayList;


public class ParenthesisChecker {
    public int parenthesisChecker = 0;
    public  void ParenthesisCheckerAnalyze(ArrayList<ArithmeticExpressionValues> values) throws ParenthesisCheckerException {

        if (values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.LEFT_PARENTHESIS) {
            if ( values.get(1).getOperators() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.OPERATORS
                    && values.get(1).getType() != ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.MINUS)
                throw new ParenthesisCheckerException("wrong parentheses placement");
            else {
                parenthesisChecker++;
            }
        } else if (values.get(0).getType() == ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.RIGHT_PARENTHESIS) throw new ParenthesisCheckerException("wrong parentheses placement");
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
