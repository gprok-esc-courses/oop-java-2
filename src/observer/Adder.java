package observer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Adder {
    private ArrayList<ErrorObserver> errorObservers;

    public Adder() {
        errorObservers = new ArrayList<>();
    }

    public void addErrorObserver(ErrorObserver observer) {
        errorObservers.add(observer);
    }

    public void errorHappened(String message) {
        for(ErrorObserver observer : errorObservers) {
            observer.error(message);
        }
    }

    public void add() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Number a");
            int a = scanner.nextInt();
            System.out.print("Number b");
            int b = scanner.nextInt();
            System.out.println(a + " + " + b + " = " + (a + b));
        }
        catch (InputMismatchException e) {
            errorHappened("Wrong input, integers only required");
        }
    }
}
