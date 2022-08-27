package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdater {
    private final String sqlAdd = "INSERT INTO ArithmeticExpression" +
                        "(arithmeticExpression, arithmeticExpressionResult)" +
                        "VALUES (?,?)";
    private final String sqlDelete = "DELETE from ArithmeticExpression";
    private final String sqlUpdate = "UPDATE ArithmeticExpression SET arithmeticExpression = (?), arithmeticExpressionResult = (?) WHERE arithmeticExpression like (?) ";
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
