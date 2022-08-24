package com.geeksforless.yevdokymov.exeption;

public class ParenthesisCheckerException extends Exception{
    public ParenthesisCheckerException(String message, char character) {
        super(message);
    }
}
