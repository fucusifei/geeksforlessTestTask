package com.geeksforless.yevdokymov.javaCore;

import com.geeksforless.yevdokymov.exсeption.UnexpectedCharacterException;


import java.util.ArrayList;

/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ArithmeticExpressionValuesAnalyze - клас для аналізу строки та заповнення списку об'єктів типу ArithmeticExpressionValues
 */
public class ArithmeticExpressionValuesAnalyze {
    public ArrayList<ArithmeticExpressionValues> values = new ArrayList<>();

    /**
     * Метод аналізу строки у StringBuilder та запису посимвольно у список як об'єкт типу ArithmeticExpressionValues
     *
     * @param arithmeticExpression введений користувачем арифметичний вираз
     */
    public void analyze(StringBuilder arithmeticExpression) throws UnexpectedCharacterException{
        // змінна для проходження по всіх елементах списку
        int positionChecker = 0;
        while (positionChecker < arithmeticExpression.length()) {
            // змінна в яку зберігається один символ по індексу positionChecker з введеного арифметичного виразу
            char c = arithmeticExpression.charAt(positionChecker);

            // запис усіх символів арифметичного виразу зі StringBuilder arithmeticExpression до списку об'єктів зі своїми типами
            // ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2 потрібен для майбутньої перевірки правильності розстановки операторів та дужок
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
                        // зациклюємо операцію пошуку числа, якщо воно двузначне і більше, для його коректного запису у список
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
                    // якщо присутній сторонній символ, такий як буква або оператори, що не входять в ТЗ, викидаємо UnexpectedCharacterException
                    else if (c != ' ') throw new UnexpectedCharacterException("unexpected character");
                    else if (c == ' ') {
                        positionChecker++;
                    }

                }
            }
        }
        values.add(new ArithmeticExpressionValues(ArithmeticExpressionValues.ArithmeticExpressionValuesTypes.EOF, "", ArithmeticExpressionValues.ArithmeticExpressionValuesTypes2.EOF));
    }
}
