package riddle2;

import java.util.ArrayList;

/**
 * Maintains the logic og a riddle game.
 * Holds a number of riddles (currently 4) each time we start a game
 * Checks given answers, and updates score.
 * Also saves score to the database and retrieves top scorers to be displayed.
 */
public class Game {
    /** list of riddle for a game */
    private ArrayList<Riddle> riddles;

    /** score of a game */
    private int score;

    /** username of the user currently playing */
    private String username;

    /** current riddle to be asked */
    private int current;

    private int size;

    private Database database;

    public Game(int size) {
        this.size = size;
        database = new Database();
        database.addErrorObserver(new ErrorLogger());
        database.addErrorObserver(new ErrorTweet());
        database.connect();
    }

    public boolean isGameOK() {
        return riddles != null && riddles.size() == size;
    }

    /**
     * Starts a new riddle game by initializing all the necessary variables
     */
    public void startGame() {
        RiddleReader reader = new RiddleReader();
        reader.addErrorObserver(new ErrorLogger());
        reader.addErrorObserver(new ErrorTweet());
        riddles = reader.getRiddles(size);
        score = 0;
        current = 0;
    }

    /**
     * Provides the current question
     * @return current question
     */
    public String getCurrentQuestion() {
        return riddles.get(current).getQuestion();
    }

    /**
     * Checks the correctness of a given answer, towards the current riddle and updates score if necessary.
     * Then proceeds to the next riddle.
     * @param answer the answer to be checked
     */
    public void checkCurrentAnswer(String answer) {
        if(riddles.get(current).isCorrect(answer)) {
            increaseScore();
        }
        current++;
    }

    /**
     * Sets the username of the current player
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Increases the score by one
     */
    public void increaseScore() {
        score++;
    }


    /**
     * Provides the score of the current game
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Provides the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public int getSize() {
        return size;
    }

    public void saveScore() {
        database.saveScore(username, score);
    }

    public boolean gameOver() {
        return current == size;
    }
}
