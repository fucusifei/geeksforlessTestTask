package com.geeksforless.yevdokymov.db;

import java.sql.*;

public class Viewer {
    String sql = "SELECT * FROM ArithmeticExpression";
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
