package introduction;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        int secret;
        int guess;
        int counter = 0;

        // Generate secret
        Random rnd = new Random();
        secret = rnd.nextInt(100);

        // Make it possible to read from the command line
        Scanner input = new Scanner(System.in);

        do {
            counter++;
            System.out.print("Guess: ");
            guess = input.nextInt();
            if(guess > secret) {
                System.out.println("Go DOWN");
            }
            else if(guess < secret) {
                System.out.println("Go UP");
            }
        } while(secret != guess);

        System.out.println("Found in " + counter + " guesses");
    }
}
