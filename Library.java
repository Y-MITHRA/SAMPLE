// Library.java
public class Library {
    private LibraryDatabase database;

    public Library(LibraryDatabase database) {
        this.database = database;
    }

    public void addBook(Book book) {
        database.addBook(book);
    }

    public void removeBook(String bookId) {
        database.removeBook(bookId);
    }

    public Book searchBook(String bookId) {
        return database.searchBook(bookId);
    }
}
