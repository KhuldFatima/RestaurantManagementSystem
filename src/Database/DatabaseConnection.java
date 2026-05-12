package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/restaurant_db";

    private static final String USER = "root";

    private static final String PASSWORD = "SQL@313";

    public static Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            return conn;

        } catch (SQLException e) {

            System.out.println("Connection Failed!");
            e.printStackTrace();

            return null;
        }
    }
}