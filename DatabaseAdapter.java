// DatabaseAdapter.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAdapter implements LibraryDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/library1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Override
    public void addBook(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO books (id, title, author, year_published, genre) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getYearPublished());
            statement.setString(5, book.getGenre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(String bookId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book searchBook(String bookId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(resultSet.getString("id"),
                                resultSet.getString("title"),
                                resultSet.getString("author"),
                                resultSet.getInt("year_published"),
                                resultSet.getString("genre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
