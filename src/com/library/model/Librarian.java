package com.library.model;

public class Librarian extends User {
    public Librarian(String name, String id) {
        super(name, id);
    }

    @Override
    public String getRole() {
        return "Librarian";
    }
}
