package hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String [] words = {
            "encapsulation", "inheritance", "polymorphism",
            "constructor", "function", "parameter", "compiler",
            "interpreter", "executable", "debugger"
    };
    private String secret;
    private String wrongLetters;
    private String correctLetters;

    public void playAgain() {
        Random rnd = new Random();
        int pos = rnd.nextInt(words.length-1);
        secret = words[pos];
        System.out.println(secret);
        wrongLetters = "";
        correctLetters = "";
    }

    public String getSecretWord() {
        String secretWord = "";
        secretWord += secret.charAt(0);
        for(int i = 1; i < secret.length()-1; i++) {
            String s = "" + secret.charAt(i);
            if(correctLetters.contains(s)) {
                secretWord += s;
            }
            else {
                secretWord += "_";
            }
        }
        secretWord += secret.charAt(secret.length()-1);
        return secretWord;
    }

    public void guess() {
        Scanner input = new Scanner(System.in);
        System.out.print("Guess: ");
        String guessLetter = input.next();
        if(guessLetter.length() > 1) {
            System.out.println("Error: Type one letter only");
        }
        else if(secret.contains(guessLetter)) {
            correctLetters += guessLetter;
        }
        else {
            wrongLetters += guessLetter;
        }
     }

     public boolean isHanged() {
        return wrongLetters.length() == 6;
     }

     public boolean isFound() {
         for(int i = 1; i < secret.length()-1; i++) {
             String s = "" + secret.charAt(i);
             if(!correctLetters.contains(s)) {
                 return false;
             }
         }
         return true;
     }
}
