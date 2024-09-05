import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Add some books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"));
        
        // Borrow a book
        String isbnToBorrow = "9780743273565";
        if (library.borrowBook(isbnToBorrow)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book not available for borrowing.");
        }
        
        // Return a book
        String isbnToReturn = "9780743273565";
        if (library.returnBook(isbnToReturn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Unable to return the book.");
        }
    }
}