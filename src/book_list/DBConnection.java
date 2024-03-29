package book_list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_library",
                    "test", "test");
            return con;

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the DB");
        }
        return null;
    }
}
