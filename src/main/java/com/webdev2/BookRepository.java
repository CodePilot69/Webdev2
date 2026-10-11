package com.webdev2;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Task 3 — Repository layer.
 * Stores Book objects in a Map<Long, Book> (in-memory, no database).
 * Provides save, findById, findAll, update, and delete.
 */
@Repository
public class BookRepository {

    private final Map<Long, Book> store    = new LinkedHashMap<>();
    private final AtomicLong      idSeq    = new AtomicLong(1);

    // Pre-load sample data
    public BookRepository() {
        save(new Book(null, "Clean Code",               "Robert C. Martin", "9780132350884", 2008));
        save(new Book(null, "The Pragmatic Programmer", "Andrew Hunt",       "9780201616224", 1999));
        save(new Book(null, "Effective Java",           "Joshua Bloch",      "9780134685991", 2018));
    }

    /** Persist a new book — assigns an auto-incremented ID. */
    public Book save(Book book) {
        book.setId(idSeq.getAndIncrement());
        store.put(book.getId(), book);
        return book;
    }

    /** Return all books in insertion order. */
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    /** Return a single book by ID, or empty if not found. */
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /** Replace the stored book with the updated version. */
    public void update(Book book) {
        store.put(book.getId(), book);
    }

    /** Remove a book by ID. */
    public void deleteById(Long id) {
        store.remove(id);
    }
}
