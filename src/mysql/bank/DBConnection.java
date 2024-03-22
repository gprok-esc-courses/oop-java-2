package mysql.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_java",
                    "test2", "1234");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found");
        } catch (SQLException e) {
            System.out.println("Query has a problem");
        }
        return null;
    }
}
