package book_list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String publicationDate;
    private long numberOfPages;

    public Book(int id, String isbn, String title, String publicationDate, long numberOfPages) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    public Book(String isbn, String title, String publicationDate, long numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    public boolean save() {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO books (isbn, title, publication_date, pages) VALUES " +
                "(?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, isbn);
            st.setString(2, title);
            st.setString(3, publicationDate);
            st.setLong(4, numberOfPages);
            st.execute();
            int count = st.getUpdateCount();
            if(count > 0) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Query problem");
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
