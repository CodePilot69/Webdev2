package com.webdev2;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Task 4 — Web Controller for full CRUD operations on Book.
 *
 * GET  /books          → list all books
 * GET  /books/new      → show create form
 * POST /books          → save new book (+ validation)
 * GET  /books/{id}/edit → show edit form
 * POST /books/{id}     → update book (+ validation)
 * POST /books/{id}/delete → delete book
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ── READ — List all books ─────────────────────────────────────────────────

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    // ── CREATE — Show form ────────────────────────────────────────────────────

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    // ── CREATE — Handle submission ────────────────────────────────────────────

    @PostMapping
    public String createBook(@Valid @ModelAttribute Book book,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";          // redisplay form with errors
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    // ── UPDATE — Show pre-populated edit form ─────────────────────────────────

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Book> found = bookService.getBookById(id);
        if (found.isEmpty()) {
            return "redirect:/books";
        }
        model.addAttribute("book", found.get());
        return "books/edit";
    }

    // ── UPDATE — Handle submission ────────────────────────────────────────────

    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute Book book,
                             BindingResult result) {
        if (result.hasErrors()) {
            book.setId(id);               // keep ID on the model for the form action
            return "books/edit";
        }
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
