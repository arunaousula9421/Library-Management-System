import com.library.model.Book;
import com.library.model.User;
import com.library.storage.BookRepository;
import com.library.storage.UserRepository;
import com.library.service.BookService;
import com.library.service.InventoryService;
import com.library.service.UserService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();

        BookService bookService = new BookService(bookRepository);
        InventoryService inventoryService = new InventoryService(bookRepository, userRepository);

        User patron = UserService.createUser("Patron", "Arunkumar", "P01" );
        User librarian = UserService.createUser("Librarian", "Airtribe", "L01");

        userRepository.addUser(patron);
        userRepository.addUser(librarian);

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", 1949);

        bookService.addBook(book1);
        bookService.addBook(book2);

        // List of all available books
        List<Book> allBooks = bookRepository.getAllBooks();
        System.out.println("List of all books: ");
        for (Book book : allBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println();

        //List of all type of users
        System.out.println("Patron User: "+userRepository.getUserById("P01").getName());
        System.out.println("Librarian User: "+userRepository.getUserById("L01").getName());

        System.out.println();

        // Print inventory status
        System.out.println("Available books: " + inventoryService.getAvailableBookCount());
        System.out.println("Borrowed books: " + inventoryService.getBorrowedBookCount());

        System.out.println();

        //Borrow Book
        inventoryService.checkoutBook("9780451524935", "P01");

        // Print inventory status
        System.out.println("Available books: " + inventoryService.getAvailableBookCount());
        System.out.println("Borrowed books: " + inventoryService.getBorrowedBookCount());

        //Search by Title
        List<Book> getBookByTitle = bookService.searchByTitle("1984");
        for (Book book : getBookByTitle) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " is published in year " + book.getPublicationYear());
        }
    }
}