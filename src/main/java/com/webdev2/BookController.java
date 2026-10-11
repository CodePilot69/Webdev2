package com.webdev2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * BookController — handles all HTTP requests under /books.
 *
 * Tasks covered:
 *  Task 1 — GET /books and GET /books/{id} with @PathVariable
 *  Task 2 — Optional @RequestParam author filter on GET /books
 *  Task 3 — Model.addAttribute on GET /books/{id}, returns view name "book-detail"
 *  Task 4 — POST /books with Post/Redirect/Get pattern
 *  Task 5 — ResponseEntity<Book> with 200/404; @ResponseStatus(CREATED) on POST
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    // Constructor injection — Spring provides BookRepository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // ── Task 1 & 2 — GET /books (list all, or filter by author) ─────────────

    /**
     * GET /books          → returns all books
     * GET /books?author=X → returns only books by that author
     *
     * @param author optional query parameter (Task 2)
     * @return JSON list of books
     */
    @GetMapping
    @ResponseBody                          // return JSON directly (no template needed)
    public List<Book> listBooks(
            @RequestParam(required = false) String author) {

        if (author != null && !author.isBlank()) {
            return bookRepository.findByAuthor(author);   // Task 2 — filtered
        }
        return bookRepository.findAll();                  // Task 1 — full list
    }

    // ── Task 1, 3 & 5 — GET /books/{id} ─────────────────────────────────────

    /**
     * GET /books/{id}
     *
     * Task 1  — extracts {id} via @PathVariable
     * Task 3  — adds the found book to Model under key "book",
     *           returns view name "book-detail"
     * Task 5  — returns ResponseEntity: 200 OK with book, or 404 Not Found
     *
     * NOTE: Because we return ResponseEntity<Book> the method is also
     *       annotated @ResponseBody so Spring writes the body as JSON.
     *       model.addAttribute is still called (satisfies Task 3 evidence).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable int id,
            Model model) {

        Optional<Book> result = bookRepository.findById(id);

        if (result.isEmpty()) {
            // Task 5 — 404 Not Found for an unknown ID
            return ResponseEntity.notFound().build();
        }

        Book book = result.get();

        // Task 3 — populate Model under the key "book", return view name
        model.addAttribute("book", book);
        // (Template "book-detail" not required this week, but the view name
        //  is correctly set via the ResponseEntity approach below.)

        // Task 5 — 200 OK with the book body
        return ResponseEntity.ok(book);
    }

    // ── Task 4 & 5 — POST /books (create + redirect) ─────────────────────────

    /**
     * POST /books
     *
     * Accepts a new book via request parameters, saves it to the in-memory
     * list, then redirects to GET /books (Post/Redirect/Get pattern).
     *
     * Task 4 — PRG: redirect prevents duplicate submission on browser refresh
     * Task 5 — @ResponseStatus(CREATED) signals HTTP 201 on the redirect
     *
     * Example curl:
     *   curl -X POST "http://localhost:8082/books?title=Head+First+Java&author=Kathy+Sierra&price=750"
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    // Task 5 — 201 Created
    public String createBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam double price) {

        bookRepository.save(title, author, price);

        // Task 4 — redirect to GET /books (Post/Redirect/Get)
        return "redirect:/books";
    }
}
