package book_list;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMenu {

    private Scanner scanner;
    private Library library;

    public LibraryMenu() {
        scanner = new Scanner(System.in);
        library = new Library();
    }

    public int displayMenu() {
        int choice;
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("0. Exit");
        System.out.print("Select: ");
        choice = scanner.nextInt();
        return choice;
    }

    public Book findBook() {
        System.out.print("Give ISBN: ");
        String isbn = scanner.next();
        Book book = library.findBook(isbn);
        return book;
    }

    public void printAllBooks() {
        library.loadBooks();
        ArrayList<Book> books = library.getBooks();
        for(Book b : books) {
            System.out.println(b.getIsbn() + " " + b.getTitle());
        }
    }
}
