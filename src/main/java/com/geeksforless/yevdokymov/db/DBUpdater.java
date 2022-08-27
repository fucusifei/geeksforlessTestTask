package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdater {
    public String sqlAdd = "INSERT INTO ArithmeticExpression" +
                        "(arithmeticExpression, arithmeticExpressionResult)" +
                        "VALUES (?,?)";
    public String sqlDelete = "DELETE from ArithmeticExpression";
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
    public void delete(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
