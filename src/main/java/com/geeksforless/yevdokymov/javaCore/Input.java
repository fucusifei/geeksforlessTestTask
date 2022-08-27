package com.geeksforless.yevdokymov.javaCore;

import java.util.Scanner;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс Input - реалізація методу введення строки
 */
public class Input {
    public StringBuilder arithmeticExpression;
    /**
     * Метод зчитування строки з консолі та запису її у StringBuilder
     */
    public void input () {
        System.out.println("Ваш вираз ");
        Scanner in = new Scanner(System.in);
        arithmeticExpression = new StringBuilder(in.nextLine());
    }


}
