package com.geeksforless.yevdokymov.exсeption;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс OperatorsCheckerException - клас, який унаслідує клас Exception для повідомлення про некоректно розставлені оператори у арифметичному виразі
 */
public class OperatorsCheckerException extends Exception {
    public OperatorsCheckerException(String message) {
        super(message);
    }
}
