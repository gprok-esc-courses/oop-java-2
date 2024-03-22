package mysql.bank;

import java.util.Scanner;

public class Atm {
    private User user;
    private Scanner scanner;

    public Atm() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice = 0;
        int option = 0;
        do {
            choice = Menu.loginMenu();
            switch(choice) {
                case 1:
                    if(login()) {
                        do {
                            option = Menu.userMenu();
                            switch (option) {
                                case 1:
                                    System.out.println("Balance: " + user.getBalance());
                                    break;
                                case 2:
                                    System.out.print("Amount: ");
                                    int amount = scanner.nextInt();
                                    if(!user.withdraw(amount)) {
                                        System.out.println("Error, transaction failed.");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Amount: ");
                                    amount = scanner.nextInt();
                                    if(!user.deposit(amount)) {
                                        System.out.println("Error, transaction failed.");
                                    }
                                    break;
                            }
                        } while(option != 0);
                    }
                    break;
                case 2:
                    register();
                    break;
            }
        } while(choice != 0);
    }

    public void register() {
        System.out.print("Give Username: ");
        String username = scanner.next();
        System.out.print("Give Password: ");
        String password = scanner.next();
        user = new User(username, password);
        user.saveNewUser();
    }

    public boolean login() {
        System.out.print("Give Username: ");
        String username = scanner.next();
        System.out.print("Give Password: ");
        String password = scanner.next();
        user = new User(username, password);
        boolean ok = user.loadUser();
        return ok;
    }
}
