package com.geeksforless.yevdokymov.exсeption;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс UnexpectedCharacterException - клас, який унаслідує клас Exception для повідомлення про наявність недопустимих символів у арифметичному виразі
 */
public class UnexpectedCharacterException extends Exception{

    public UnexpectedCharacterException(String message) {
        super(message);
    }

}
