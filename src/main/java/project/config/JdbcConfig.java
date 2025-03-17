package project.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {
    private static final String url = "jdbc:postgresql://localhost:5432/hospitaldb";

    private static final String user = "postgres";
    private static final String password = "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
