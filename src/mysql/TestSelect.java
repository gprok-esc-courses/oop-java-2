package mysql;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "test2", "1234");

            Statement st = con.createStatement();
            String query = "SELECT * FROM product";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name") + " " +
                        rs.getDouble("price"));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
