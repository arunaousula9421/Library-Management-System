package com.library.service;

import com.library.model.Librarian;
import com.library.model.Patron;
import com.library.model.User;

public class UserService {
    public static User createUser(String role, String name, String id) {
        if (role.equalsIgnoreCase("Patron")) {
            return new Patron(name, id);
        } else if (role.equalsIgnoreCase("Librarian")) {
            return new Librarian(name, id);
        }
        return null;
    }
}
