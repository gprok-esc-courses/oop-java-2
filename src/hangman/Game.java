package hangman;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        User user = new User();
        Hangman hangman = new Hangman();
        String answer = "y";
        Scanner input = new Scanner(System.in);

        user.getName();

        do {
            hangman.playAgain();

            do {
                System.out.println(hangman.getSecretWord());
                hangman.guess();
                if(hangman.isHanged()) {
                    System.out.println("HANGED :(");
                    user.hanged();
                    break;
                }
                if(hangman.isFound()) {
                    System.out.println("FOUND :)");
                    user.found();
                    break;
                }
            } while(true);

            System.out.print("Play again (y/n)? ");
            answer = input.next();
        } while(answer.equals("y"));

        user.printScore();
    }
}
