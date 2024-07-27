package com.library.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private String id;
    private List<Book> borrowingHistory;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowingHistory = new ArrayList<>();
    }

    public abstract String getRole();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addBookToHistory(Book book) {
        this.borrowingHistory.add(book);
    }
}