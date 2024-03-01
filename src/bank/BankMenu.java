package bank;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class BankMenu {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadFromDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Activate");
            System.out.println("5. Set Credit Card");
            System.out.println("6. Set Balance");
            System.out.println("0. EXIT");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // remove the new line char

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Phone");
                    String phone = scanner.next();
                    bank.addAccount(name, address, phone);
                    break;
                case 2:
                    System.out.print("Give ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Account a = bank.getAccount(id);
                    if(a == null) {
                        System.out.println("Not found");
                    }
                    else {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.print("Give ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    String result = bank.addCreditCard(id);
                    System.out.println(result);
            }

        } while(choice != 0);
    }
}
