package com.geeksforless.yevdokymov.db;

import java.sql.*;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс Viewer - клас для реалізації методу перегляду всіх атрибутів таблиці з БД
 */
public class Viewer {
    String sql = "SELECT * FROM ArithmeticExpression";
    /**
     * Метод перегляду всіх елементів таблиці
     *
     * @param connection необхідний для під'єднання до БД
     */
    public void view(Connection connection) throws SQLException {

        try (connection) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int i = 1;
            while (resultSet.next()) {
                System.out.println(i +") Arithmetic expression: " + resultSet.getString(1) + " result:" + resultSet.getDouble(2));
                i++;
            }
        }
    }
}
