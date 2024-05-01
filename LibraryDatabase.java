
public interface LibraryDatabase {
    void addBook(Book book);
    void removeBook(String bookId);
    Book searchBook(String bookId);
}
