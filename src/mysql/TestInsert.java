package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test2", "1234");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Product: ");
            String product = scanner.next();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Stock: ");
            int stock = scanner.nextInt();

            String query = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product);
            pst.setDouble(2, price);
            pst.setInt(3, stock);

            pst.execute();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
