package riddle2;

import riddle.ErrorLogger;

import java.util.Date;
import java.util.Scanner;

/**
 * Provides the Command Line (CMD) user interface for the riddle game
 */
public class CmdUI {
    /** reads user input from the command line */
    private Scanner scanner;

    /** game logic */
    private Game game;

    /**
     * Default constructor, initializes variables
     */
    public CmdUI() {
        scanner = new Scanner(System.in);
        game = new Game(4);
    }

    /**
     * Retrieves username from the user
     */
    public void getUsername() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        game.setUsername(username);
    }

    /**
     * Displays next riddle, gets user's answer, and updates score
     */
    public void nextRiddle() {
        System.out.println(game.getCurrentQuestion());
        System.out.print("Answer: ");
        String answer = scanner.nextLine();
        game.checkCurrentAnswer(answer);
    }

    /**
     * Displays the score
     */
    public void displayScore() {
        System.out.println("SCORE: " + game.getScore() + "/" + game.getSize());
    }

    /**
     * Asks the user if they want to play again
     * @return user response yes as "y", or no as "n"
     */
    public String playAgain() {
        System.out.print("Play Again (y/n): ");
        String response = scanner.nextLine();
        return response;
    }

    /**
     * Runs the game by using the previous methods
     */
    public void run() {
        String response = "y";
        do {
            getUsername();
            if(game.getUsername().equals("exit")) {
                break;
            }
            do {
                game.startGame();
                if(!game.isGameOK()) {
                    ErrorLogger logger = new ErrorLogger();
                    logger.error(new Date() + ", " + getClass().getSimpleName() + ", " + "Game failed because of API problem");
                    System.out.println("Game failed because of API problem");
                    System.exit(1);
                }
                for (int i = 0; i < game.getSize(); i++) {
                    nextRiddle();
                }
                displayScore();
                game.saveScore();
                response = playAgain();
            } while (response.equals("y"));
        } while(true);
    }

}
