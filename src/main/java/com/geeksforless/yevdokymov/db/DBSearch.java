package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSearch {
    public void search(Connection connection, String searchWord, double result) throws SQLException {
        switch (searchWord) {
            case ">" -> {
                try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM ArithmeticExpression WHERE arithmeticExpressionResult > (?)")) {
                    statement.setDouble(1, result);
                    ResultSet a = statement.executeQuery();
                    while (a.next()) {
                        System.out.println("Необхідний вираз: " + a.getString(1));
                    }
                }
                finally {
                    connection.close();
                }
            }
            case  "<"-> {
                try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM ArithmeticExpression WHERE arithmeticExpressionResult < (?)")) {
                    statement.setDouble(1, result);
                    ResultSet a = statement.executeQuery();
                    while (a.next()) {
                        System.out.println("Необхідний вираз: " + a.getString(1));
                    }
                }
                finally {
                    connection.close();
                }
            }
            case "=" -> {
                try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM ArithmeticExpression WHERE arithmeticExpressionResult = (?)")) {
                    statement.setDouble(1, result);
                    ResultSet a = statement.executeQuery();
                    while (a.next()) {
                        System.out.println("Необхідний вираз: " + a.getString(1));
                    }
                }
                finally {
                    connection.close();
                }
            }
            case "<=" -> {
                try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM ArithmeticExpression WHERE arithmeticExpressionResult <= (?)")) {
                    statement.setDouble(1, result);
                    ResultSet a = statement.executeQuery();
                    while (a.next()) {
                        System.out.println("Необхідний вираз: " + a.getString(1));
                    }
                }
                finally {
                    connection.close();
                }
            }
            case  ">="-> {
                try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM ArithmeticExpression WHERE arithmeticExpressionResult >= (?)")) {
                    statement.setDouble(1, result);
                    ResultSet a = statement.executeQuery();
                    while (a.next()) {
                        System.out.println("Необхідний вираз: " + a.getString(1));
                    }
                }
                finally {
                    connection.close();
                }
            }
            default -> {
                System.out.println("wrong search word");
            }
        }
    }
}
