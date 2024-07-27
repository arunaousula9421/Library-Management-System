package com.library.service;

import com.library.model.Book;
import com.library.storage.BookRepository;

import java.util.List;
import java.util.ArrayList;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void removeBook(String ISBN) {
        bookRepository.removeBook(ISBN);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book searchByISBN(String ISBN) {
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
}