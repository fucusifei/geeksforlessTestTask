package com.geeksforless.yevdokymov.exсeption;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ParenthesisCheckerException - клас, який унаслідує клас Exception для повідомлення про некоректно розставлені дужки у арифметичному виразі
 */
public class ParenthesisCheckerException extends Exception{
    public ParenthesisCheckerException(String message) {
        super(message);
    }
}
