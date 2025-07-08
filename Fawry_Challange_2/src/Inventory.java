import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String , Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getISBN() , book);
        System.out.println("Book add - " + book.title);
    }
    public Book removeOutdatedBook(String ISBN , int years) {
        Book book = inventory.get(ISBN);
        if (book != null && (Year.now().getValue() - book.getYear()) > years) {
            inventory.remove(ISBN);
            System.out.println("Book removed - " + book.title);
            return book;
        }
        return null;
    }

    public void buyBook(String ISBN , int quantity , String email , String address) {
        Book book = inventory.get(ISBN);
        if(book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        book.buy(quantity , email , address);
    }
}
