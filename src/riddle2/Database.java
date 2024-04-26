package riddle2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Maintains a connection with the database and run any queries necessary.
 * Uses a MySQL database at localhost
 */
public class Database {
    /** connection to the database */
    private Connection connection;

    private ArrayList<ErrorObserver> observers;


    /**
     * Class default constructor
     * Initializes the DB connection.
     */
    public Database() {
        observers = new ArrayList<>();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riddles",
                    "test", "test");
        } catch (ClassNotFoundException e) {
            error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            connection = null;
        } catch (SQLException e) {
            error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            connection = null;
        }
    }

    public void addErrorObserver(ErrorObserver obs) {
        observers.add(obs);
    }

    public void error(String message) {
        for(ErrorObserver e : observers) {
            e.error(message);
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
            error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            return false;
        }
    }
}
