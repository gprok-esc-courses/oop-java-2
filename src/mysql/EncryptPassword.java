package mysql;

import org.mindrot.jbcrypt.BCrypt;
import java.util.Scanner;

public class EncryptPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Password: ");
        String password = scanner.next();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(hashedPassword);

        System.out.print("Password again: ");
        password = scanner.next();

        boolean match = BCrypt.checkpw(password, hashedPassword);
        System.out.println(match);
    }
}
