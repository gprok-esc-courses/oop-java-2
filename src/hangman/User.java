package hangman;

import java.util.Scanner;

public class User {
    private String name;
    private int counterFound;
    private int counterHanged;

    public User() {
        name = "N/A";
        counterFound = 0;
        counterHanged = 0;
    }

    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Give your name: ");
        name = input.next();
    }

    public void printScore() {
        System.out.println(name + " your score is:");
        System.out.println("FOUND: " + counterFound);
        System.out.println("HANGED: " + counterHanged);
    }

    public void hanged() {
        counterHanged++;
    }

    public void found() {
        counterFound++;
    }

}
