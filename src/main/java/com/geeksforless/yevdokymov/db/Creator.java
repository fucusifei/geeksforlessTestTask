package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creator {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String username = "postgres";
    public static final String password = "1111";
    public static final String SQL_TABLES_CREATOR = "CREATE TABLE IF NOT EXISTS public.ArithmeticExpression" +
            "(" +
            "IdArithmeticExpression integer NOT NULL DEFAULT 1," +
            "arithmeticExpression character varying COLLATE pg_catalog.default," +
            "arithmeticExpressionResult integer," +
            "CONSTRAINT ArithmeticExpression_pkey PRIMARY KEY (IdArithmeticExpression)" +
            ")";
    public void createNewTable() {
        try(
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_TABLES_CREATOR);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}
