package com.webdev2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Task 3 — Service layer.
 * Annotated @Service so Spring creates and manages this bean.
 * All business operations go here; data persistence is delegated
 * to BookRepository (constructor-injected — no new BookRepository()).
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** Return all books in the library. */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /** Find one book by its ID. */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /** Add a new book to the library. */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /** Update an existing book's details. */
    public void updateBook(Book book) {
        bookRepository.update(book);
    }

    /** Remove a book from the library. */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
