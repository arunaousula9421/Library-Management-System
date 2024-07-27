package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.storage.BookRepository;
import com.library.storage.UserRepository;

public class InventoryService {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public InventoryService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public boolean checkoutBook(String ISBN, String userId) {
        Book book = bookRepository.getBookByISBN(ISBN);
        User user = userRepository.getUserById(userId);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowed(true);
            user.addBookToHistory(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN) {
        Book book = bookRepository.getBookByISBN(ISBN);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }

    public int getAvailableBookCount() {
        int count = 0;
        for (Book book : bookRepository.getAllBooks()) {
            if (!book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    public int getBorrowedBookCount() {
        int count = 0;
        for (Book book : bookRepository.getAllBooks()) {
            if (book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }
}