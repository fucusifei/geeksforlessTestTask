package com.geeksforless.yevdokymov.exeption;

public class UnexpectedCharacterException extends Exception{
    private char character;

    public UnexpectedCharacterException(String message, char character) {
        super(message);
        this.character = character;
    }
    public char getCharacter() {
        return character;
    }

}
