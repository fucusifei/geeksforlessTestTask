package com.geeksforless.yevdokymov;

import java.util.Scanner;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс Input - реалізація методу введення строки
 */
public class Input {
    public StringBuilder arithmeticExpression;
    public void input () {
        Scanner in = new Scanner(System.in);
        arithmeticExpression = new StringBuilder(in.nextLine());
    }


}
