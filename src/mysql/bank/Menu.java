package mysql.bank;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static int loginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public static int userMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("0. EXIT");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        return choice;
    }


}
