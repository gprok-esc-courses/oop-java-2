package book_list;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void loadBooks() {
        books = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        if(con != null) {
            try {
                String query = "SELECT * FROM books";
                PreparedStatement st = con.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while(rs.next()) {
                    Book book = new Book(rs.getInt("id"), rs.getString("isbn"),
                            rs.getString("title"), rs.getString("publication_date"),
                            rs.getInt("pages"));
                    books.add(book);
                }
            } catch (SQLException e) {
                System.out.println("Problem running statement");
            }
        }
    }

    public Book findBook(String isbn) {
        try {
            URL url = new URL("https://openlibrary.org/isbn/" + isbn + ".json");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            Book book = new Book(isbn, (String) json.get("title"),
                    (String) json.get("publish_date"), (long) json.get("number_of_pages"));
            return book;
        } catch (MalformedURLException e) {
            System.out.println("Bad URL");
        } catch (IOException e) {
            System.out.println("Cannot open API stream");
        } catch (ParseException e) {
            System.out.println("Cannot parse JSON");
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
