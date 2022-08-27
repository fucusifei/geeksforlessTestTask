package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс DBUpdater - клас для реалізації методів взаємодії з БД
 */
public class DBUpdater {
    private final String sqlAdd = "INSERT INTO ArithmeticExpression" +
                        "(arithmeticExpression, arithmeticExpressionResult)" +
                        "VALUES (?,?)";
    private final String sqlDelete = "DELETE from ArithmeticExpression";
    private final String sqlUpdate = "UPDATE ArithmeticExpression SET arithmeticExpression = (?), arithmeticExpressionResult = (?) WHERE arithmeticExpression like (?) ";
    /**
     * Метод додавання нових елементів в БД
     *
     * @param connection необхідний для під'єднання до БД
     * @param arithmeticExpression вираз, який потрібно додати до БД
     * @param result результат обчислення arithmeticExpression
     */
    public void add(Connection connection, String arithmeticExpression, double result) {
        try {
            PreparedStatement statement = connection.prepareStatement(sqlAdd);
            statement.setString(1,arithmeticExpression);
            statement.setDouble(2, result);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Метод видалення всіх елементів в БД
     *
     * @param connection необхідний для під'єднання до БД
     */
    public void delete(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Метод оновлення елементів в БД
     *
     * @param connection необхідний для під'єднання до БД
     * @param arithmeticExpression вираз, який потрібно додати до БД
     * @param result результат обчислення arithmeticExpression
     * @param arithmeticExpressionToChange вираз, який потрібно замінити
     */
    public void update(Connection connection, String arithmeticExpression, String arithmeticExpressionToChange, double result) {
        try {
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1,arithmeticExpression);
            statement.setDouble(2, result);
            statement.setString(3, arithmeticExpressionToChange);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
