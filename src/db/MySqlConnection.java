package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    private final static String DB_URL = "jdbc:mysql://localhost:8889/pp2_membership";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "root";

    private static MySqlConnection instance;

    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
