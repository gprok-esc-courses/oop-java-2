package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test2", "1234");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Product ID: ");
            int id = scanner.nextInt();
            System.out.print("Stock: ");
            int stock = scanner.nextInt();

            String query = "UPDATE product SET stock=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, stock);
            pst.setInt(2, id);

            pst.execute();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
