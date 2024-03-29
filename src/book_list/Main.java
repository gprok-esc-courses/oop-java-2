package book_list;

public class Main {
    public static void main(String[] args) {
        LibraryMenu menu = new LibraryMenu();
        int choice = 0;
        do {
            choice = menu.displayMenu();
            switch(choice) {
                case 1:
                    Book book = menu.findBook();
                    if(book != null) {
                        book.save();
                    }
                    break;
                case 2:
                    menu.printAllBooks();
                    break;
            }
        } while (choice != 0);
    }
}
