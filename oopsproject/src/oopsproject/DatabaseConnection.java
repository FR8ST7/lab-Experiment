package oopsproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/patient_management"; // Database URL
        String user = "root"; 
        String password = "03@Frost"; // Change this to your MySQL root password

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
}
