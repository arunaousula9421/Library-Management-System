**Library Management System**

This Java project is a simple Library Management System that demonstrates Object-Oriented Programming (OOP) concepts, SOLID principles, and design patterns. Below is an explanation of each class used in the project.

### Package Map

```
library
├── Main.java
├── model
│   ├── Book.java
│   ├── User.java
│   ├── Patron.java
│   └── Librarian.java
├── storage
│   ├── BookRepository.java
│   └── UserRepository.java
└── service
    ├── BookService.java
    ├── InventoryService.java
    └── UserFactory.java
```

### Class Explanations

#### 1. `Main` Class
**Package:** `library`<br />
**Explanation:** The entry point of the application. It sets up the repository and service objects, adds some sample data, performs some operations (like adding books and users, checking out and returning books), and prints the current state of the inventory.

#### 2. `Book` Class
**Package:** `library.model`<br />
**Explanation:** Represents a book with attributes such as title, author, ISBN, publication year, and borrowing status. It includes getters and setters for its attributes.

#### 3. `User` Class
**Package:** `library.model`<br />
**Explanation:** An abstract class representing a library user with common attributes such as name, ID, and borrowing history. It has an abstract method `getRole()` to be implemented by subclasses.

#### 4. `Patron` Class
**Package:** `library.model`<br />
**Explanation:** Inherits from `User` and represents a patron in the library. Implements the `getRole()` method to return "Patron".

#### 5. `Librarian` Class
**Package:** `library.model`<br />
**Explanation:** Inherits from `User` and represents a librarian in the library. Implements the `getRole()` method to return "Librarian".

#### 6. `BookRepository` Class
**Package:** `library.storage`<br />
**Explanation:** Manages the storage and retrieval of `Book` objects. Provides methods to add, remove, update, and fetch books, as well as get a list of all books.

#### 7. `UserRepository` Class
**Package:** `library.storage`<br />
**Explanation:** Manages the storage and retrieval of `User` objects. Provides methods to add and fetch users by ID.

#### 8. `BookService` Class
**Package:** `library.service`<br />
**Explanation:** Provides business logic for managing books. Uses `BookRepository` to add, remove, update, and search for books by title, author, or ISBN. Also provides a method to get a list of all books.

#### 9. `InventoryService` Class
**Package:** `library.service`<br />
**Explanation:** Manages the lending process. Uses `BookRepository` and `UserRepository` to handle book checkouts and returns. Also provides methods to get the count of available and borrowed books.

#### 10. `UserFactory` Class
**Package:** `library.service`<br />
**Explanation:** Implements the Factory design pattern to create instances of `User` subclasses (`Patron` and `Librarian`) based on the specified role.

### How to Run

1. Compile the Java files:

    ```sh
    javac Main.java
    ```

2. Run the application:

    ```sh
    java Main.java
    ```