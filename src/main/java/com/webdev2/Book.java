package com.webdev2;

import jakarta.validation.constraints.*;

/**
 * Task 2 — Domain entity: Book
 *
 * 4 fields (+ id):  title, author, isbn, year
 * 5 distinct Bean Validation annotations:
 *   @NotBlank, @Size, @Pattern, @NotNull, @Min / @Max
 */
public class Book {

    private Long id;

    // Constraint 1: @NotBlank — title must not be empty
    @NotBlank(message = "Title is required")
    // Constraint 2: @Size — title length between 1 and 100 chars
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    // Constraint 3: @NotBlank — author must not be empty
    @NotBlank(message = "Author name is required")
    private String author;

    // Constraint 4: @Pattern — must be a 13-digit ISBN
    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be exactly 13 digits")
    private String isbn;

    // Constraint 5: @Min / @Max — reasonable publication year range
    @NotNull(message = "Publication year is required")
    @Min(value = 1000, message = "Year must be 1000 or later")
    @Max(value = 2100, message = "Year must be 2100 or earlier")
    private Integer year;

    // ── No-arg constructor required for Thymeleaf form binding ───────────────
    public Book() {}

    public Book(Long id, String title, String author, String isbn, Integer year) {
        this.id     = id;
        this.title  = title;
        this.author = author;
        this.isbn   = isbn;
        this.year   = year;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────
    public Long    getId()                { return id; }
    public void    setId(Long id)         { this.id = id; }

    public String  getTitle()             { return title; }
    public void    setTitle(String t)     { this.title = t; }

    public String  getAuthor()            { return author; }
    public void    setAuthor(String a)    { this.author = a; }

    public String  getIsbn()              { return isbn; }
    public void    setIsbn(String i)      { this.isbn = i; }

    public Integer getYear()              { return year; }
    public void    setYear(Integer y)     { this.year = y; }
}
