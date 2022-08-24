package com.geeksforless.yevdokymov;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionValues - клас, який зберігає дані про кожен символ зчитуваної строки та його тип
 */
public class ArithmeticExpressionValues {
    @Override
    public String toString() {
        return "ArithmeticExpressionValues{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    public enum ArithmeticExpressionValuesTypes{
        NUMBER, MINUS, PLUS, MULTIPLY, DIVIDE, LEFT_PARENTHESIS, RIGHT_PARENTHESIS, EOF
    }
    public ArithmeticExpressionValuesTypes type;
    public String value;

    public ArithmeticExpressionValues(ArithmeticExpressionValuesTypes type, String value) {
        this.type = type;
        this.value = value;
    }
    public ArithmeticExpressionValues(ArithmeticExpressionValuesTypes type, Character value) {
        this.type = type;
        this.value = value.toString();
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

}
