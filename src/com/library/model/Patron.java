package com.library.model;

public class Patron extends User {
    public Patron(String name, String id) {
        super(name, id);
    }

    @Override
    public String getRole() {
        return "Patron";
    }
}