package com.geeksforless.yevdokymov.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Богдан Євдокимов
 * @version 1.0
 * Класс ConnectionToDb - клас для реалізації методу підключення до БД
 */
public class ConnectionToDb {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String username = "postgres";
    public static final String password = "1111";
      Connection connection = null;
    /**
     * Метод підключення до БД
     */
    public Connection getConnectionToDb() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
