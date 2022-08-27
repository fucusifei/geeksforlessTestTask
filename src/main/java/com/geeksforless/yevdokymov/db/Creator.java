package com.geeksforless.yevdokymov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс Creator - клас для реалізації методу створення БД
 */
public class Creator {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String username = "postgres";
    public static final String password = "1111";
    public static final String SQL_TABLES_CREATOR = "CREATE TABLE IF NOT EXISTS public.ArithmeticExpression" +
            "(" +
            "arithmeticExpression character varying COLLATE pg_catalog.default," +
            "arithmeticExpressionResult double precision" +
            ")";
    /**
     * Метод створення БД
     */
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
