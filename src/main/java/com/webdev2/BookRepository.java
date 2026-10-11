package com.webdev2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In-memory repository for Book objects.
 * Replaces a real database for this lab.
 */
@Repository
public class BookRepository {

    // Auto-incrementing ID counter
    private final AtomicInteger idCounter = new AtomicInteger(4);

    // Pre-populated in-memory list
    private final List<Book> books = new ArrayList<>(List.of(
        new Book(1, "Clean Code",              "Robert C. Martin", 850.00),
        new Book(2, "The Pragmatic Programmer", "Andrew Hunt",      920.00),
        new Book(3, "Effective Java",           "Joshua Bloch",    1100.00)
    ));

    /** Returns all books. */
    public List<Book> findAll() {
        return List.copyOf(books);
    }

    /** Returns books filtered by author (case-insensitive partial match). */
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().toLowerCase()
                              .contains(author.toLowerCase()))
                .toList();
    }

    /** Finds a single book by its ID. */
    public Optional<Book> findById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst();
    }

    /** Saves a new book, assigning the next available ID. */
    public Book save(String title, String author, double price) {
        Book book = new Book(idCounter.getAndIncrement(), title, author, price);
        books.add(book);
        return book;
    }
}
