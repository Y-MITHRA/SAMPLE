// Main.java
public class Main {
    public static void main(String[] args) {
        // Initialize DatabaseAdapter
        DatabaseAdapter adapter = new DatabaseAdapter();

        // Initialize Library with the adapter
        Library library = new Library(adapter);

        // Example usage
        Book book = new Book("003", "Maths Book", "Ram", 2003, "Fiction");
        library.addBook(book);
		
        Book foundBook = library.searchBook("002");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}
