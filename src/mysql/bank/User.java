package mysql.bank;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String password;
    private int balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, int balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public boolean saveNewUser() {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO users (username, password, balance) VALUES (?, ?, 0)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            pst.setString(2, hashedPassword);

            pst.execute();
        } catch (SQLException e) {
            System.out.println("Query error");
        }
        return true;
    }

    public boolean loadUser() {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM users WHERE username=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                boolean match = BCrypt.checkpw(password, rs.getString("password"));
                if(match) {
                    id = rs.getInt("id");
                    balance = rs.getInt("balance");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Query error");
            return false;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if(amount <= balance) {
            int newBalance = balance - amount;
            Connection con = DBConnection.getConnection();
            String query = "UPDATE users SET balance=? WHERE id=?";
            try {
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, newBalance);
                pst.setInt(2, id);
                pst.execute();
                balance = newBalance;
                return true;
            } catch (SQLException e) {
                System.out.println("Query error");
                return false;
            }
        }
        return false;
    }

    public boolean deposit(int amount) {
        int newBalance = balance + amount;
        Connection con = DBConnection.getConnection();
        String query = "UPDATE users SET balance=? WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, newBalance);
            pst.setInt(2, id);
            pst.execute();
            balance = newBalance;
            return true;
        } catch (SQLException e) {
            System.out.println("Query error");
            return false;
        }
    }
}
