package com.geeksforless.yevdokymov;

import java.util.Scanner;
public class Input {
    public StringBuilder arithmeticExpression;
    public void input () {
        Scanner in = new Scanner(System.in);
        arithmeticExpression = new StringBuilder(in.nextLine());
    }


}
