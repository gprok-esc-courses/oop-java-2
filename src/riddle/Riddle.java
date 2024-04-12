package riddle;

/**
 * Represents one Riddle entity
 */
public class Riddle {
    /** the question of the riddle */
    private String question;
    /** the correct answer to the riddle */
    private String answer;

    /**
     * Class constructor
     * @param question gives the question of the riddle
     * @param answer gives the correct answer to the riddle
     */
    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Gives the question of the riddle
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Checks if a string contains the correct answer to the riddle
     * @param answer the string to be checked
     * @return true id string is correct, false otherwise
     */
    public boolean isCorrect(String answer) {
        return this.answer.equals(answer);
    }

    @Override
    public String toString() {
        return "Q: " + question + "\nA: " + answer;
    }
}
