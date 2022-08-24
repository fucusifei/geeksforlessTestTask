package com.geeksforless.yevdokymov.javaCore;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionValues - клас, який зберігає дані про кожен символ зчитуваної строки та його тип
 */
public class ArithmeticExpressionValues {
    public enum ArithmeticExpressionValuesTypes{
        NUMBER, MINUS, PLUS, MULTIPLY, DIVIDE, LEFT_PARENTHESIS, RIGHT_PARENTHESIS, EOF
    }
    public enum ArithmeticExpressionValuesTypes2{
        NUMBERS, OPERATORS, PARENTHESIS, EOF
    }
    public ArithmeticExpressionValuesTypes type;
    public String value;

    public ArithmeticExpressionValuesTypes2 operators;

    public ArithmeticExpressionValues(ArithmeticExpressionValuesTypes type, String value, ArithmeticExpressionValuesTypes2 operators) {
        this.type = type;
        this.value = value;
        this.operators = operators;
    }
    public ArithmeticExpressionValues(ArithmeticExpressionValuesTypes type, Character value, ArithmeticExpressionValuesTypes2 operators) {
        this.type = type;
        this.value = value.toString();
        this.operators = operators;
    }

    public ArithmeticExpressionValuesTypes getType() {
        return type;
    }

    public void setType(ArithmeticExpressionValuesTypes type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArithmeticExpressionValuesTypes2 getOperators() {
        return operators;
    }

    public void setOperators(ArithmeticExpressionValuesTypes2 operators) {
        this.operators = operators;
    }

}
