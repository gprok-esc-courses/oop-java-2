package riddle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Maintains a connection with the database and run any queries necessary.
 * Uses a MySQL database at localhost
 */
public class Database {
    /** connection to the database */
    private Connection connection;

    /**
     * Class default constructor
     * Initializes the DB connection.
     */
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riddles",
                    "test", "test");
        } catch (ClassNotFoundException e) {
            connection = null;
        } catch (SQLException e) {
            connection = null;
        }
    }

    /**
     * Inserts the result of a game into the database
     * @param username the username of the player
     * @param score the score achieved
     * @return true if insertion was successful
     */
    public boolean saveScore(String username, int score) {
        String query = "INSERT INTO scores (username, date_time, score) VALUES (?, NOW(), ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setInt(2, score);
            st.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
